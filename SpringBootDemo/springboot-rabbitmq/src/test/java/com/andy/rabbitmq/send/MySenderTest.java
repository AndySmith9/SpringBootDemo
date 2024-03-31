package com.andy.rabbitmq.send;

import java.util.Date;

import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.andy.rabbitmq.ApplicationTests;

@Component
public class MySenderTest extends ApplicationTests {

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Test
	public void test() {
		amqpTemplate.convertAndSend("myQueue", "now:"+new Date());
	}
	
}
