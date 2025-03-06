package com.demo.orderapp.controller;

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
        Order order = orderService.getByBarcode(orderDto.getBarCode());
        order.setQty(orderDto.getQuantity());
        order.setTotalPrice(orderDto.getQuantity() * order.getPrice());
        return ResponseEntity.ok(orderService.updateOrder(order));
    }

    @PostMapping("orders")
    public ResponseEntity<Order> placeOrder(@RequestBody OrderDto orderDto) {
        InventoryDto inventoryDto = inventoryProxy.getItem(orderDto.getBarCode());
        if(inventoryDto ==null){
            throw new ProductNotFound("Product not found");
        }
        ProductBean product = productProxy.getProductByBarcode(orderDto.getBarCode());
        if (product == null) {
            throw new RuntimeException("Product not found");
        }
        if(orderDto.getQuantity()>inventoryProxy.getItemQuantity(orderDto.getBarCode())){
            throw new ProductQuantityExceeded("Exceeded the available Quantity count"+"Qunatity available+"+inventoryProxy.getItemQuantity(orderDto.getBarCode()));
        }
        int updated_quantity = inventoryProxy.getItemQuantity(orderDto.getBarCode()) - orderDto.getQuantity();
        inventoryDto.setQuantity(updated_quantity);
        inventoryProxy.updateItem(inventoryDto);
        inventoryProxy.updateItem(inventoryDto);
        // Save Order in Database (Assuming JPA is used)
        Order order = new Order();
        order.setQty(orderDto.getQuantity());
        order.setPrice(product.getPrice());
        order.setProductName(product.getName());
        order.setDescription(product.getDescription());
        order.setCategory(product.getCategory());
        order.setBarCode(product.getBarCode());
        order.setTotalPrice(orderDto.getQuantity() * product.getPrice());
        order.setBillingAddress(Converter.toOrder(orderDto.getBillingAddress()));
        Order order1 = orderService.createOrder(order);
        return ResponseEntity.ok(orderService.createOrder(order));
    }

    @Transactional
    @DeleteMapping("orders/{barCode}")
    public void  deleteOrder(@PathVariable String barCode) {
        if(orderService.getByBarcode(barCode)==null){
            throw new RuntimeException("Order not found");
        }
        Order order = orderService.getByBarcode(barCode);
        int updated_quantity = inventoryProxy.getItemQuantity(barCode)+order.getQty();
        InventoryDto inventoryDto = inventoryProxy.getItem(barCode);
        inventoryDto.setQuantity(updated_quantity);
        inventoryProxy.updateItem(inventoryDto);
        orderService.deleteByBarCode(barCode);
        System.out.println("the delete is successful");
    }
}
