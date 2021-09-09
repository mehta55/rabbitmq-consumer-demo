package com.nagarro.RabbitMQConsDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitMqConsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqConsDemoApplication.class, args);
		System.out.println("Started consumer..");
	}

}
