package com.zrd.study.spring.mq.receive;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class DemoReceiver {
	@JmsListener(destination="demoDestination")
	public void receive(String message){
		System.out.println("接收到消息：" + message);
	}
	
	@RabbitListener(queues="demoqueue")
	public void receiveRabbitMq(String msg){
		System.out.println("rabbitmq:" + msg);
	}
}
