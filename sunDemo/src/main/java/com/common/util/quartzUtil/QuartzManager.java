package com.common.util.quartzUtil;

import org.apache.log4j.Logger;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author sc
 * @date 2018/11/21
 */
@Service
public class QuartzManager {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private Scheduler scheduler;

    /**
     * @Description: 添加一个定时任务
     * @param jobName 任务名
     * @param jobGroupName 任务组名
     * @param triggerName 触发器名
     * @param triggerGroupName 触发器组名
     * @param jobClass 任务
     * @param text 通知数据
     * @param inMinutes 时间间隔【分钟】
     * @param count 通知次数
     */
    @SuppressWarnings("unchecked")
    public void addJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName,
                       Class jobClass, String text ,Integer inMinutes, Integer count) {
        try {
            // 任务名，任务组，任务执行类
            JobDetail jobDetail= JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroupName).build();
            jobDetail.getJobDataMap().put("name",jobName);
            jobDetail.getJobDataMap().put("group",jobGroupName);
            jobDetail.getJobDataMap().put("text",text);
            SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger().withIdentity(jobName,jobGroupName)
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMinutes(inMinutes).withRepeatCount(count)).startNow().build();
            // 调度容器设置JobDetail和Trigger
            scheduler.scheduleJob(jobDetail, simpleTrigger);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 添加任务
     * @param jobName
     * @param jobGroupName
     * @param triggerName
     * @param triggerGroupName
     * @param jobClass
     */
    public void addDbJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName, Class jobClass) {
        try {
            // 任务名，任务组，任务执行类
            JobDetail jobDetail= JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroupName).build();
            jobDetail.getJobDataMap().put("name",jobName);
            jobDetail.getJobDataMap().put("group",jobGroupName);

            Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerName,jobGroupName)
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 0 1 * * ?")).startNow().build();

            // 调度容器设置JobDetail和Trigger
            scheduler.scheduleJob(jobDetail, trigger);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * @Description: 修改一个任务的触发时间
     * @param jobName 任务名
     * @param jobGroupName 任务组名
     * @param triggerName 触发器名
     * @param triggerGroupName 触发器组名
     * @param cron 时间设置，参考quartz说明文档
     */
    public void modifyJobTime(String jobName,
                                     String jobGroupName, String triggerName, String triggerGroupName, String cron) {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            if (trigger == null) {
                return;
            }

            String oldTime = trigger.getCronExpression();
            if (!oldTime.equalsIgnoreCase(cron)) {
                /** 方式一 ：调用 rescheduleJob 开始 */
                // 触发器
                TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
                // 触发器名,触发器组
                triggerBuilder.withIdentity(triggerName, triggerGroupName);
                triggerBuilder.startNow();
                // 触发器时间设定
                triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
                // 创建Trigger对象
                trigger = (CronTrigger) triggerBuilder.build();
                // 方式一 ：修改一个任务的触发时间
                scheduler.rescheduleJob(triggerKey, trigger);
                /** 方式一 ：调用 rescheduleJob 结束 */

                /** 方式二：先删除，然后在创建一个新的Job  */
                //JobDetail jobDetail = sched.getJobDetail(JobKey.jobKey(jobName, jobGroupName));
                //Class<? extends job> jobClass = jobDetail.getJobClass();
                //removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
                //addJob(jobName, jobGroupName, triggerName, triggerGroupName, jobClass, cron);
                /** 方式二 ：先删除，然后在创建一个新的Job */
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description: 移除一个任务
     * @param jobName
     * @param jobGroupName
     * @param triggerName
     * @param triggerGroupName
     */
    public void removeJob(String jobName, String jobGroupName,
                                 String triggerName, String triggerGroupName) {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
            // 停止触发器
            scheduler.pauseTrigger(triggerKey);
            // 移除触发器
            scheduler.unscheduleJob(triggerKey);
            // 删除任务
            scheduler.deleteJob(JobKey.jobKey(jobName, jobGroupName));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description:启动所有定时任务
     */
    public void startJobs() {
        try {
            scheduler.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description:关闭所有定时任务
     */
    public void shutdownJobs() {
        try {
            if (!scheduler.isShutdown()) {
                scheduler.shutdown();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
