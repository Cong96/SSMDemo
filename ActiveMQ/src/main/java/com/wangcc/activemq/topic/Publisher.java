package com.wangcc.activemq.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.wangcc.activemq.Constants;

public class Publisher {
	public static void main(String[] args) {
		// 连接工厂
		ConnectionFactory factory;
		// 连接实例
		Connection connection = null;
		// 收发的线程实例
		Session session;
		// 消息发送目标地址
		Destination destination;

		try {
			// 实例化连接工厂
			factory = new ActiveMQConnectionFactory(Constants.ACTIVEMQ_USER, Constants.ACTIVEMQ_PSW,
					Constants.ACTIVEMQ_URL);
			// 获取连接实例
			connection = factory.createConnection();
			// 启动连接
			connection.start();
			// 创建接收或发送的线程实例（创建session的时候定义是否要启用事务，且事务类型是Auto_ACKNOWLEDGE也就是消费者成功在Listern中获得消息返回时，会话自动确定用户收到消息）
			session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
			// 创建队列（返回一个消息目的地）
			destination = session.createTopic("parryTopic");
			// 创建消息发布者
			MessageProducer producer = session.createProducer(destination);
			// 创建TextMessage消息
			TextMessage message = session.createTextMessage("你好，这是我发布的第一条消息！");
			// 发布消息
			producer.send(message);
			System.out.println("Done");
			session.commit();
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
					System.out.println("Closed");
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
