package com.springboot.amqp.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import com.springboot.amqp.MessagingApplication;

@Configuration
public class AmqpRabbitConfiguration {

	@Bean
	public TopicExchange topicExchange() {
	return new TopicExchange(MessagingApplication.EXCHANGE_NAME);
	}
	
	@Bean
	public Queue genericQueue() {
		return new Queue(MessagingApplication.QUEUE_GENERIC_NAME);
	}
	
	@Bean
	public Queue customQueue() {
		return new Queue(MessagingApplication.QUEUE_SPECIFIC_NAME);
	}

	@Bean
	public String routingKey() {
		return MessagingApplication.ROUTING_KEY;
	}
	
	@Bean
	public Binding genericBindind() {
		return BindingBuilder.bind(genericQueue()).to(topicExchange()).with(routingKey());
	}
	
	@Bean
	public Binding customBindind() {
		return BindingBuilder.bind(customQueue()).to(topicExchange()).with(routingKey());
	}

	 // You can comment the two methods below to use the default serialization / deserialization (instead of JSON)
	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		final var rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
		return rabbitTemplate;
	}
	
	@Bean
	public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
}