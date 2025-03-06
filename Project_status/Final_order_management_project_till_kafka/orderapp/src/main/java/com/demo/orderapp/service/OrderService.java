package com.demo.orderapp.service;

import com.demo.orderapp.dto.OrderDto;
import com.demo.orderapp.entity.Order;

import java.util.List;

public interface OrderService {
    public Order getByBarcode(String barCode);
    public List<Order> getAllOrders();
    public Order createOrder(OrderDto orderDto);
    public Order getOrderById(int id);
    public Order updateOrder(OrderDto orderDto);
    public void deleteOrder(int id);
    public void deleteByBarCode(String barCode);

}
