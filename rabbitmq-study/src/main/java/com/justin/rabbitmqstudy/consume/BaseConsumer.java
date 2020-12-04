package com.justin.rabbitmqstudy.consume;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = "default-q1")
public class BaseConsumer {

    @RabbitHandler
    public void receive(String message){
        System.out.println("收到direct消息:" + message);
        throw new RuntimeException("hhh");
    }
}
