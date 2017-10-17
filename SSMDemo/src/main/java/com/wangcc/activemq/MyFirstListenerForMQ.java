package com.wangcc.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

//其实像这种回调方法，更多的是直接采用匿名类的方式在调用方法处直接创建
public class MyFirstListenerForMQ implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			System.out.println("收到消息：" + ((TextMessage) message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
