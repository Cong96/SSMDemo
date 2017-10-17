package com.wangcc.activemq.spring.service;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

/**
 * @ClassName: ProducerService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author wangcc
 * @date 2017年10月17日 下午6:24:03
 *       MessageListenerAdapter除了会自动的把一个普通Java类当做MessageListener来处理接收到的消息之外，其另外一个主要的功能是可以自动的发送返回消息。
 *       当我们用于处理接收到的消息的方法的返回值不为空的时候，Spring会自动将它封装为一个JMS
 *       Message，然后自动进行回复。那么这个时候这个回复消息将发送到哪里呢？这主要有两种方式可以指定。
 *       第一，可以通过发送的Message的setJMSReplyTo方法指定该消息对应的回复消息的目的地。这里我们把我们的生产者发送消息的代码做一下修改，在发送消息之前先指定该消息对应的回复目的地为一个叫responseQueue的队列目的地
 */
@Service
public class ProducerService {
	@Autowired
	private JmsTemplate jmsTemplate;
	// @Autowired
	// @Qualifier("responseQueue")
	//
	// private Destination responseDestination;

	public void sendMessage(Destination destination, final String message) {
		System.out.println("---------------生产者发送消息-----------------");
		System.out.println("---------------生产者发了一个消息：" + message);
		jmsTemplate.send(destination, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {

				TextMessage textMessage = session.createTextMessage(message);
				// textMessage.setJMSReplyTo(responseDestination);
				return textMessage;
				// return session.createTextMessage(message);
			}
		});
	}
}
