package com.xyl.mq.four;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

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
        //创建一个队列
        Queue queue = session.createQueue("xyl_queue");
        //创建一个消息的生产者
        MessageProducer producer = session.createProducer(queue);
        //创建一个消息
        TextMessage message = session.createTextMessage("hello word!");
        //发送消息
        producer.send(message);
        //关闭资源
        producer.close();
        session.close();
        connection.close();
    }
}
