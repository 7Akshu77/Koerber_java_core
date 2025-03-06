package com.notificationapp.service;

import com.demo.orderapp.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.from}")  // Inject from application.properties
    private String fromEmail;

    @KafkaListener(topics = "order-topic", groupId = "order-group")
    public void listenOrderNotification(Order order) {
        System.out.println("Received notification for order comformation: "+order );
        String subject = "Order Confirmation";
        String text = "Thank you for your order!\n\n" +
                "Order Details:\n" +
                "Product: " + order.getProductName() + "\n" +
                "Quantity: " + order.getQty() + "\n" +
                "Total Amount: $" + order.getTotalPrice() + "\n\n" +
                "Billing Address:\n" + order.getBillingAddress();
        sendEmail(order.getEmailId(), subject, text);
    }

    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);  // Set the "From" address
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
        System.out.println("Order placed successfully");
    }
}
