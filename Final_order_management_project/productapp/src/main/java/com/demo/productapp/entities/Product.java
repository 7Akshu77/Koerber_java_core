package com.demo.productapp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")

public class Product {

    @Id
    private int id;
    private String name;
    private String description;
    private String category;
    private float price;
    private String barCode;
    private Date mfg;


}
