package com.xyl.mq.four;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * Created by meridian on 2019/7/23.
 */
public class Consumer {
    public static void main(String[] args) throws Exception {
        //创建一个连接工厂
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://10.1.1.68:61616");
        factory.setTrustAllPackages(true);
        //获得一个连接
        Connection connection = factory.createConnection();
        //开启连接
        connection.start();
        //创建一个session
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //创建一个队列
        Queue queue = session.createQueue("xyl_queue");
        //创建一个消费者
        MessageConsumer consumer = session.createConsumer(queue);
        //注册一个监听器
        consumer.setMessageListener(new MessageListener());
        //让消费者处于监听状态
        System.in.read();
        //关闭资源
        consumer.close();
        session.close();
        connection.close();
    }
}
