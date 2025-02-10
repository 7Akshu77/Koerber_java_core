package com.demoapp.producer.controller;

import com.demoapp.producer.dto.Order;
import com.demoapp.producer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    ProducerService producerService;


    @PostMapping(path = "order")
    public String placeOrder(@RequestBody Order order) {
        producerService.placeOrder(order);
        return "Order placed successfully";
    }
}
