package com.andy.rabbitmq.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQController {

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@GetMapping("/send")
	public void send() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		amqpTemplate.convertAndSend("myQueue", "now:"+simpleDateFormat.format(new Date()) );
	}
	
	@GetMapping("/sendGroup")
	public void sendGroup() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		amqpTemplate.convertAndSend("myOrderExchange","computer", "now:"+simpleDateFormat.format(new Date()) );
	}
}
