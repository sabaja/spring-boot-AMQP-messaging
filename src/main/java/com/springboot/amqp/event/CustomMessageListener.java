package com.springboot.amqp.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.springboot.amqp.domain.CustomMessage;

@Service
public class CustomMessageListener {

	private static final Logger log = LoggerFactory.getLogger(CustomMessageListener.class);
	
	@RabbitListener(queues = "${queue.generic.name}")
	public void receiveMessage(final Message message) {
		log.info("Generic message received {}", message.toString());
	}
	
	@RabbitListener(queues = "${queue.specific.name}")
	public void receiveMessage(final CustomMessage customMessage) {
		log.info("Custom message received {}", customMessage.toString());
	}
}
