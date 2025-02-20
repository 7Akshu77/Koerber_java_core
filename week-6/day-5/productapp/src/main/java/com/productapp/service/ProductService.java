package com.productapp.service;

import com.productapp.repo.Product;
import org.springframework.data.mongodb.repository.Query;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

public interface ProductService {
public List<Product> findAll();
    public Product findById(String id);
    public Product findAndModifyNameAndCost(String id ,String name, Double cost);
    public void multiUpdate();
    public void findAndRemove(Double cost);
    public void findAllAndRemove(Double cost);
    public void upsert(String id ,String name, Double cost);
    public void findProductsByVendor(String vendor);
    public void findProductsByQtysGreaterThan(int qty);


}
