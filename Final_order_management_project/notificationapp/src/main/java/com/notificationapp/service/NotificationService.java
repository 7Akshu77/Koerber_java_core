package com.notificationapp.service;

import com.demo.orderapp.entity.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    @KafkaListener(topics = "order-topic", groupId = "email-group")
    public void sendInvoice(Order order) {
        System.out.println("📧 Sending invoice to: " + order.getUserEmail());
        // Call email service here
    }
}
