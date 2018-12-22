package com.springboot.amqp.event;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.springboot.amqp.MessagingApplication;
import com.springboot.amqp.domain.CustomMessage;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomMessageListener {

	
	@RabbitListener(queues = MessagingApplication.QUEUE_GENERIC_NAME)
	public void receiverMessage(final Message message) {
		log.info("Generic message received {}", message.toString());
	}
	
	@RabbitListener(queues = MessagingApplication.QUEUE_SPECIFIC_NAME)
	public void receiverMessage(final CustomMessage message) {
		log.info("Custom message received {}", message.toString());
	}
}
