package com.wangcc.activemq.spring.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueueMesssageListener implements MessageListener {
	private static Logger logger = LoggerFactory.getLogger(QueueMesssageListener.class);

	public void onMessage(Message message) {
		TextMessage textMsg = (TextMessage) message;
		System.out.println("接收到一个纯文本消息。");
		logger.info("接收到一个纯文本消息。");
		try {
			System.out.println("消息内容是：" + textMsg.getText());
			logger.info("消息内容是:{}", textMsg.getText());
		} catch (JMSException e) {
			logger.error("TopicMessageListener Error:{}", e);

		}
	}

}
