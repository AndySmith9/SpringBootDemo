package com.andy.rabbitmq.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.stereotype.Component;

@Component
public class MyReceiver {
private static final Logger log = LoggerFactory.getLogger(MyReceiver.class);

//手动创建队列
//@RabbitListener(queues = "myQueue")
//自动创建队列
//@RabbitListener(queuesToDeclare = @Queue("myQueue"))
//自动创建,Exchange和Queue绑定
@RabbitListener(bindings = @QueueBinding(
		value= @Queue("myQueue"),
		exchange = @Exchange("myExchange")
		))
public void process(String message) {
	log.info("MyReceiver:{}",message);
}
	
	
@RabbitListener(bindings = @QueueBinding(
		exchange = @Exchange("myOrderExchange"),
		key = "computer",
		value= @Queue("computerOrderQueue")
		))
public void processComputer(String message) {
	log.info("Computer MyReceiver:{}",message);
}
@RabbitListener(bindings = @QueueBinding(
		exchange = @Exchange("myOrderExchange"),
		key = "fruit",
		value= @Queue("fruitOrderQueue")
		))
public void processFruit(String message) {
	log.info("Fruit MyReceiver:{}",message);
}



}
