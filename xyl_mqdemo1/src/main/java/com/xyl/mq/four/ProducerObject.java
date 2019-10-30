package com.xyl.mq.four;

import com.xyl.mq.three.Person;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

/**
 * Created by meridian on 2019/7/23.
 */
public class ProducerObject {
    public static void main(String[] args) throws Exception{
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
        //创建一个消息的生产者
        MessageProducer producer = session.createProducer(queue);
        for (int i=0;i<10;i++){
            //创建一个消息
            //TextMessage message = session.createTextMessage("hello word!");
            ObjectMessage message = session.createObjectMessage();
            Person person = new Person("张三",12,"男");
            message.setObject(person);
            //发送消息
            producer.send(message);
        }
        //关闭资源
        producer.close();
        session.close();
        connection.close();
    }
}
