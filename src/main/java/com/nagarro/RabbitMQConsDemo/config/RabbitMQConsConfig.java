package com.nagarro.RabbitMQConsDemo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nagarro.RabbitMQConsDemo.RabbitMQConsumer;

//@Configuration
public class RabbitMQConsConfig {

	@Value("${rabbitmq.queue.name}")
	private String queue;
	
	@Bean
	Queue queue() {
		return new Queue(queue);
	}

	@Bean
	MessageListenerAdapter listenerAdapter(RabbitMQConsumer consumer)
	{
		return new MessageListenerAdapter(consumer, "consumed");
	}
	
	@Bean
	SimpleMessageListenerContainer container(
			ConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter)
	{
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(queue);
		container.setMessageListener(listenerAdapter);
		return container;
	}

}
