package com.deadLock.demo;

/**
 * main函数测试
 *
 * @author sunchao
 * @create 2018/6/20
 */
//运行时采用jps查询相关虚拟机进程的pid
//jstack pid 可查看具体死锁进程及原因
//taskkill /f /t /im pid 可终结相关进程

public class DeadLockMain {

    public static void main(String[] args){
        DeadLock dl = new DeadLock();
        Thread0 t0 = new Thread0(dl);
        Thread1 t1 = new Thread1(dl);
        t0.start();
        t1.start();
    }
}
