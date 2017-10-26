package com.wangcc.activemq.spring.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TopicMessageListener implements MessageListener {
	private static Logger logger = LoggerFactory.getLogger(TopicMessageListener.class);

	public void onMessage(Message message) {
		// 这里我们知道生产者发送的就是一个纯文本消息，所以这里可以直接进行强制转换 ,一般来说，需要判断
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
