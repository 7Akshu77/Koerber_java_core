package com.demo.orderapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private String barCode;
    private int quantity;
    private AddressDto billingAddress;
    private String emailId;
}
