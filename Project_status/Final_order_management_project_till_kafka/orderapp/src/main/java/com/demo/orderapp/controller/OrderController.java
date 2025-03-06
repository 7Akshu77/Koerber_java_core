package com.demo.orderapp.controller;

//import com.demo.orderapp.config.KafkaConfig;
import com.demo.orderapp.dto.InventoryDto;
import com.demo.orderapp.dto.OrderDto;
import com.demo.orderapp.dto.ProductBean;
import com.demo.orderapp.entity.Order;
import com.demo.orderapp.exceptions.ProductNotFound;
import com.demo.orderapp.exceptions.ProductQuantityExceeded;
import com.demo.orderapp.service.OrderService;
import com.demo.orderapp.serviceproxy.InventoryServiceProxy;
import com.demo.orderapp.serviceproxy.ProductServiceProxy;
import com.demo.orderapp.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

//    @Autowired
//    KafkaConfig kafkaConfig;


    private OrderService orderService;
    private ProductServiceProxy productProxy;
    private InventoryServiceProxy inventoryProxy;

    @Autowired
    public OrderController(OrderService orderService , ProductServiceProxy productProxy, InventoryServiceProxy inventoryProxy) {
        this.orderService = orderService;
        this.productProxy = productProxy;
        this.inventoryProxy = inventoryProxy;
    }

    @GetMapping("orders")
    public ResponseEntity<List<Order>> getOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable int id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @PutMapping("orders")
    public ResponseEntity<Order> updateOrder(@RequestBody OrderDto orderDto) {
        return ResponseEntity.ok(orderService.updateOrder(orderDto));
    }

    @PostMapping("orders")
    public ResponseEntity<Order> placeOrder(@RequestBody OrderDto orderDto) {
        System.out.println("order placed successfully ");
        return ResponseEntity.status(201).body(orderService.createOrder(orderDto));

    }

    @Transactional
    @DeleteMapping("orders/{barCode}")
    public void  deleteOrder(@PathVariable String barCode) {
        orderService.deleteByBarCode(barCode);
        System.out.println("the delete is successful");
    }
    @GetMapping("orders/barcode/{barCode}")
    public Order getByBarCode(String barCode){
        return orderService.getByBarcode(barCode);
    }
}
