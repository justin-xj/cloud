package com.justin.rabbitmqstudy.controller;

import com.justin.rabbitmqstudy.product.BaseProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitController {

    @Autowired
    private BaseProduct baseProduct;

    @RequestMapping("/hello1")
    public String hello1(String message){
        baseProduct.sendMessage(message);
        return "hello world!";
    }
}
