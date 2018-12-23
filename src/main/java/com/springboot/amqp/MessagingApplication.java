package com.springboot.amqp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MessagingApplication {

	public static final String EXCHANGE_NAME = "appExchange";
	public static final String QUEUE_GENERIC_NAME = "appGenericQueue";
	public static final String QUEUE_SPECIFIC_NAME = "appSpecificQueue";
	public static final String ROUTING_KEY = "messages.key";
	
	public static void main(String[] args) {
		SpringApplication.run(MessagingApplication.class, args);
	}
}

