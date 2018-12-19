package com.springboot.amqp.config;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.slf4j.Slf4j;

/**
 * https://thepracticaldeveloper.com/2016/10/23/produce-and-consume-json-messages-with-spring-boot-amqp/
 * @author sabaja
 *
 */
@Slf4j
public class CustomSenderMessage {

	private final RabbitTemplate rabbitTemplate;

	public CustomSenderMessage(RabbitTemplate rabbitTemplate) {
		super();
		this.rabbitTemplate = rabbitTemplate;
	}

//	TODO
	@Scheduled(fixedDelay = 3000L)
	public void sendMessage() {
	}

}
