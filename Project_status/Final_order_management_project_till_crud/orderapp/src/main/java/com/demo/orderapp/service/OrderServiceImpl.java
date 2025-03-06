package com.demo.orderapp.service;

import com.demo.orderapp.dto.OrderDto;
import com.demo.orderapp.entity.Order;
import com.demo.orderapp.exceptions.OrderNotFound;
import com.demo.orderapp.repository.OrderRepo;
import com.demo.orderapp.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    KafkaTemplate<String , Order> kafkaTemplate;

    private OrderRepo orderRepo;
    @Autowired
    public void setOrderRepo(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public Order createOrder(Order order) {
         orderRepo.save(order);
        return order;
    }

    @Override
    public Order getOrderById(int id) {
        return orderRepo.findById(id).orElseThrow(()-> new OrderNotFound("Order not found"));
    }

    @Override
    public Order updateOrder(Order order) {
        Order order1 = orderRepo.findById(order.getId()).orElseThrow(()-> new OrderNotFound("Order not found"));
        order1.setProductName(order.getProductName());
        order1.setBarCode(order.getBarCode());
        order1.setBillingAddress(order.getBillingAddress());
        order1.setPrice(order.getPrice());
        orderRepo.save(order);
        kafkaTemplate.send("order-topic", order);
        return order;
    }

    @Override
    public void deleteOrder(int id) {
        Order order = orderRepo.findById(id).orElseThrow(()-> new OrderNotFound("Order not found"));
        orderRepo.delete(order);

    }

    @Override
    public void deleteByBarCode(String barCode) {
        orderRepo.deleteByBarCode(barCode);
    }

    @Override
    public Order getByBarcode(String barCode){
        if(orderRepo.findByBarCode(barCode) == null) {
            throw new OrderNotFound("order not found");
        }
        return orderRepo.findByBarCode(barCode);
    }
}
