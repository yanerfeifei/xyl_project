package com.xyl.mq.four;

import com.xyl.mq.three.Person;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

/**
 * Created by meridian on 2019/7/23.
 */
public class MessageListener implements javax.jms.MessageListener {

    public void onMessage(Message message) {
        if(message instanceof TextMessage){
            TextMessage tm =(TextMessage)message;
            try {
                System.out.println("收到的文本消息消息时："+tm.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
        if(message instanceof ObjectMessage){
            ObjectMessage tm = (ObjectMessage)message;
            try {
                System.out.println("收到的对象消息是："+tm.getObject());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
