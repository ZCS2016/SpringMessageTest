package com.example.Kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @KafkaListener(topics = "test")
    public void processMessage(String message){
        System.out.println(message);
    }

}
