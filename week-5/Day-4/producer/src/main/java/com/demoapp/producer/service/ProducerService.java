package com.demoapp.producer.service;

import com.demoapp.producer.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    KafkaTemplate<String , Order>kafkaTemplate;

    @Autowired
    public ProducerService(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void placeOrder(Order order) {
        kafkaTemplate.send("order", order);
        System.out.println("message is send....");

    }
}
