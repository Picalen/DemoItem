package com.activeMQ.demo.topic;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
/**
 * Listerner01 订阅者01的监听器
 *
 * @author sunchao
 * @create 2018/7/4
 */

public class Listerner01 implements MessageListener{

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("订阅者01接收到消息：" + ((TextMessage)message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
