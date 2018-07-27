package com.example.RabbitMQ.web.controller;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/RabbitMQ")
public class RabbitMQController {
    public static final String QUEUE_NAME = "Test";

    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    AmqpAdmin rabbitAdmin;

    @RequestMapping("/setQueue")
    public String setQueue(){
        Queue queue = new Queue(QUEUE_NAME);
        rabbitAdmin.declareQueue(queue);
        rabbitTemplate.setQueue(QUEUE_NAME);
        return "OK";
    }

    @RequestMapping("/send")
    public String send(){
        String message = "Hello World!";
        rabbitTemplate.convertAndSend(QUEUE_NAME,message);
        return message;
    }

    @RequestMapping("/receive")
    public String receive(){
        String message = (String)rabbitTemplate.receiveAndConvert(QUEUE_NAME,10000);
        return message;
    }
}
