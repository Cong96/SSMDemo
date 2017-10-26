package com.wangcc.activemq.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wangcc.activemq.Constants;

public class QueueProvider {
	private static Logger logger = LoggerFactory.getLogger(QueueProvider.class);

	public static void main(String[] args) {
		ConnectionFactory connectionFactory = null;
		Connection connection = null;
		Session session = null;
		Destination destination = null;
		MessageProducer messageProducer = null;
		try {
			connectionFactory = new ActiveMQConnectionFactory(Constants.ACTIVEMQ_USER, Constants.ACTIVEMQ_PSW,
					Constants.ACTIVEMQ_URL);
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);

			destination = session.createQueue("firstQueue");
			messageProducer = session.createProducer(destination);
			TextMessage textMessage = session.createTextMessage();
			textMessage.setText("KOBE");
			messageProducer.send(textMessage);
			session.commit();
			logger.info("Send SUCCESS!");
		} catch (Exception e) {
			logger.error("JMS QueueProvider ERROR:", e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (JMSException e) {
					logger.error("Close JMS Connection  ERROR:", e);
				}
			}
		}
	}
}
