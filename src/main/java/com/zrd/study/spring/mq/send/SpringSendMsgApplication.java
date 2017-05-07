package com.zrd.study.spring.mq.send;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class SpringSendMsgApplication implements CommandLineRunner{
	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSendMsgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		jmsTemplate.send("demoDestination", new DemoMsg());
		rabbitTemplate.convertAndSend("demoqueue", "rabbitMq的消息");
	}
}
