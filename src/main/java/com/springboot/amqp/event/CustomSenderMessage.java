package com.springboot.amqp.event;

import java.util.Random;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

import com.springboot.amqp.MessagingApplication;
import com.springboot.amqp.domain.CustomMessage;

import lombok.extern.slf4j.Slf4j;

/**
 * https://thepracticaldeveloper.com/2016/10/23/produce-and-consume-json-messages-with-spring-boot-amqp/
 * 
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
	public void sendMessage(@Value("{custom.message}") String customMessage) {
		var message = new CustomMessage(customMessage, new Random().nextInt(150), false);
		log.info("sending message...details[{}]", message);
		this.rabbitTemplate.convertAndSend(MessagingApplication.EXCHANGE_NAME, MessagingApplication.ROUTING_KEY,
				message);
		log.info("message sent");
	}

}
