package com.justin.rabbitmqstudy.config;

import org.springframework.amqp.core.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitmqConfig {


    @Bean
    public Queue helloQueue(){
        return new Queue("default-q1");
    }

}
