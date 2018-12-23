package com.springboot.amqp.event;

import java.util.Random;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.springboot.amqp.MessagingApplication;
import com.springboot.amqp.domain.CustomMessage;

import lombok.extern.slf4j.Slf4j;

/**
 * https://thepracticaldeveloper.com/2016/10/23/produce-and-consume-json-messages-with-spring-boot-amqp/
 * 
 * @author sabaja
 *
 */
@Service
@Slf4j
public class CustomMessageSender {

	
	private final RabbitTemplate rabbitTemplate;
	@Value("${custom.message}")
	private String customMessage;

	public String getCustomMessage() {
		return customMessage;
	}

	public void setCustomMessage(String customMessage) {
		this.customMessage = customMessage;
	}

	@Autowired
	public CustomMessageSender(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	@Scheduled(fixedDelay = 3000L)
	public void sendMessage() {
		var message = new CustomMessage(customMessage, new Random().nextInt(150), false);
		log.info("sending message...details[text:{}, priority:{}, secret:{}]", message.getText(), message.getPriority(), message.isSecret());
		this.rabbitTemplate.convertAndSend(MessagingApplication.EXCHANGE_NAME, MessagingApplication.ROUTING_KEY,
				message);
		log.info("message sent");
	}

}
