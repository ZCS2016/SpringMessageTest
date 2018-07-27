package com.example.Kafka.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Kafka")
public class KafkaController {
    private static final String TOPIC = "test";
    @Autowired
    private KafkaAdmin kafkaAdmin;
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @RequestMapping("/send")
    public String send(){
        String message = "Hello World!";
        kafkaTemplate.send(TOPIC,message);
        return message;
    }

}
