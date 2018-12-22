package com.springboot.amqp.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * https://thepracticaldeveloper.com/2016/10/23/produce-and-consume-json-messages-with-spring-boot-amqp/
 */
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class CustomMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4505478899787416295L;

	private String text;
	private Integer priority;
	private boolean secret;

	public CustomMessage(@JsonProperty("test") String text, @JsonProperty("priority") Integer priority,
			@JsonProperty("secret") boolean secret) {
		super();
		this.text = text;
		this.priority = priority;
		this.secret = secret;
	}

	@Override
	public String toString() {
		return "CustomMessage{" + "text='" + text + "'" + ", priority=" + priority + ", secret=" + secret + "}";

	}
}
