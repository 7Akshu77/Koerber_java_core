package com.demo.orderapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String barCode;
    private float TotalPrice;
    private String productName;
    private String description;
    private String category;
    private int qty;
    private String emailId;
    private float price;
    private Address billingAddress;
}
