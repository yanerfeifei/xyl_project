package com.xyl.mq.two;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

/**
 * Created by meridian on 2019/7/23.
 */
public class Producer {
    public static void main(String[] args) throws Exception{
        //创建一个连接工厂
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://10.1.1.68:61616");
        //获得一个连接
        Connection connection = factory.createConnection();
        //开启连接
        connection.start();
        //创建一个session
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //创建一个主题
        Topic topic = session.createTopic("xyl_topic");
        //创建一个消息的生产者
        MessageProducer producer = session.createProducer(topic);
        //创建一个消息
        TextMessage message = session.createTextMessage("hello word! this is topic!");
        //发送消息
        producer.send(message);
        //关闭资源
        producer.close();
        session.close();
        connection.close();
    }
}
