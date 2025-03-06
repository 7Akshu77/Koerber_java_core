package com.demo.orderapp.service;

//import com.demo.orderapp.config.KafkaConfig;
import com.demo.orderapp.dto.InventoryDto;
import com.demo.orderapp.dto.OrderDto;
import com.demo.orderapp.dto.ProductBean;
import com.demo.orderapp.entity.Order;
import com.demo.orderapp.event.OrderEvent;
import com.demo.orderapp.exceptions.OrderNotFound;
import com.demo.orderapp.exceptions.ProductNotFound;
import com.demo.orderapp.exceptions.ProductQuantityExceeded;
import com.demo.orderapp.repository.OrderRepo;
import com.demo.orderapp.serviceproxy.InventoryServiceProxy;
import com.demo.orderapp.serviceproxy.ProductServiceProxy;
import com.demo.orderapp.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderServiceImpl implements OrderService {

    private final KafkaTemplate<String, Order> kafkaTemplate;
    private OrderRepo orderRepo;
    private InventoryServiceProxy inventoryProxy;
    private ProductServiceProxy productProxy;

    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo,KafkaTemplate kafkaTemplate , InventoryServiceProxy inventoryProxy, ProductServiceProxy productProxy) {
        this.inventoryProxy = inventoryProxy;
        this.productProxy = productProxy;
        this.orderRepo = orderRepo;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public Order createOrder(OrderDto orderDto) {
        Order order = Converter.toOrder(orderDto);
        InventoryDto inventoryDto = inventoryProxy.getItem(order.getBarCode());
        if(inventoryDto==null) throw new ProductNotFound("Product not found");
        if(order.getQty()>inventoryDto.getQuantity()) throw new ProductQuantityExceeded("Product quantity exceeded");
        ProductBean product = productProxy.getProductByBarcode(order.getBarCode());
        order.setCategory(product.getCategory());
        order.setDescription(product.getDescription());
        order.setProductName(product.getName());
        order.setPrice(product.getPrice());
        order.setTotalPrice(order.getPrice()*order.getQty());
        int updated_quantity = inventoryDto.getQuantity()-order.getQty();
        inventoryDto.setQuantity(updated_quantity);
        inventoryProxy.updateItem(inventoryDto);
        kafkaTemplate.send("order-topic",order);
         orderRepo.save(order);
        return order;
    }

    @Override
    public Order getOrderById(int id) {
        return orderRepo.findById(id).orElseThrow(()-> new OrderNotFound("Order not found"));
    }

    @Override
    public Order updateOrder(OrderDto orderDto) {
        Order order = Converter.toOrder(orderDto);
        InventoryDto inventoryDto = inventoryProxy.getItem(order.getBarCode());
        if(order.getQty()>inventoryDto.getQuantity()) throw new ProductQuantityExceeded("Product quantity exceeded");
        ProductBean product = productProxy.getProductByBarcode(order.getBarCode());
        order = Converter.toOrderFromProduct(product);
        int updated_quantity = inventoryDto.getQuantity()-order.getQty();
        inventoryDto.setQuantity(updated_quantity);
        inventoryProxy.updateItem(inventoryDto);
        orderRepo.save(order);
        return order;
    }

    @Override
    public void deleteOrder(int id) {
        Order order = orderRepo.findById(id).orElseThrow(()-> new OrderNotFound("Order not found"));
        InventoryDto inventoryDto = inventoryProxy.getItem(order.getBarCode());
        int updated_quantity = inventoryDto.getQuantity()+order.getQty();
        inventoryDto.setQuantity(updated_quantity);
        inventoryProxy.updateItem(inventoryDto);
        orderRepo.delete(order);

    }

    @Override
    public void deleteByBarCode(String barCode) {
        orderRepo.deleteByBarCode(barCode);
    }

    @Override
    public Order getByBarcode(String barCode){
        Order order  = orderRepo.findByBarCode(barCode);
        if(order == null) throw new OrderNotFound("order not found");
        return orderRepo.findByBarCode(barCode);
    }
}
