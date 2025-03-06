package com.demo.productapp.repository;

import com.demo.productapp.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends MongoRepository<Product, Integer> {
    public Product getByBarCode(String barCode);
    public Product deleteByBarCode(String barCode);
}
