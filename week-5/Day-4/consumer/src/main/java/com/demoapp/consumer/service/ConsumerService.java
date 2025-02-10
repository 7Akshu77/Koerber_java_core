package com.demoapp.consumer.service;

import com.demoapp.consumer.dto.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class ConsumerService {
    Logger logger = Logger.getLogger(ConsumerService.class.getName());

    @KafkaListener(topics = "order-topic" , groupId = "order_group")
    public void consume(Order order) {
        logger.info("Order: " + order);
    }
}
