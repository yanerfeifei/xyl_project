package com.xyl.mq.three;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.ObjectMessage;
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
        for (int i=0;i<10;i++){
            //接收消息
            //TextMessage receive = (TextMessage) consumer.receive();
            ObjectMessage receive = (ObjectMessage)consumer.receive();
            Person p = (Person) receive.getObject();
            System.out.println("接收到的消息是："+p.toString());
        }

        //关闭资源
        consumer.close();
        session.close();
        connection.close();
    }
}
