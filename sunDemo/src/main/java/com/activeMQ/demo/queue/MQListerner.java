package com.activeMQ.demo.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * MQListerner 生产者监听器
 *
 * @author sunchao
 * @create 2018/7/4
 */

public class MQListerner implements MessageListener{

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println(((TextMessage)message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}