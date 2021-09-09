package com.nagarro.RabbitMQConsDemo;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = {"logger_queue"})
public class RabbitMQConsumer {
	
	@RabbitHandler
	public void consumed(String message) {
		System.out.println(message);
	}
}
