package com.xyl.mq.two;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

/**
 * Created by meridian on 2019/7/23.
 */
public class Consumer {
    public static void main(String[] args) throws Exception {
        //创建一个连接工厂
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://10.1.1.68:61616");
        //获得一个连接
        Connection connection = factory.createConnection();
        //在持久订阅的时候需要一个id来标识
        connection.setClientID("xyl_01");
        //开启连接
        connection.start();
        //创建一个session
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //创建一个主题
        Topic topic = session.createTopic("xyl_topic");
        //创建一个消费者
        MessageConsumer consumer = session.createDurableSubscriber(topic,"xyl_topic_01");
        //接收消息
        TextMessage receive = (TextMessage) consumer.receive();
        System.out.println("consumer1接收到的消息是："+receive.getText());
        //关闭资源
        consumer.close();
        session.close();
        connection.close();
    }
}
