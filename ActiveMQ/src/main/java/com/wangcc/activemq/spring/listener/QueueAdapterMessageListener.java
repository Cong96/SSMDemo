package com.wangcc.activemq.spring.listener;

public class QueueAdapterMessageListener {
	//
	public String receiveMessage(String message) {
		System.out.println("QueueAdapterMessageListener通过receiveMessage接收到一个纯文本消息，消息内容是：" + message);
		return "这是ConsumerListener对象的receiveMessage方法的返回值。";

	}

	public void handleMessage(String message) {
		System.out.println("ConsumerListener通过handleMessage接收到一个纯文本消息，消息内容是：" + message);
	}
}
