package com.demo.orderapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductBean {
    private int id;
    private String name;
    private String description;
    private String category;
    private float price;
    private String barCode;
    private Date mfg;
}
