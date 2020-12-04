package com.justin.rabbitmqstudy.product;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseProduct {

    @Autowired
    private RabbitTemplate baseTemplate;


    public String sendMessage(String message){


        baseTemplate.convertAndSend("direct", message);


        return "";
    }
}
