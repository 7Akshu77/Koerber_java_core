package com.productapp.productapp.service;

import com.productapp.productapp.entities.Product;

import java.util.List;

import com.productapp.productapp.exception.ProductNotFound;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

public interface ProductService {

    public List<Product> getAllProduct();
    public Product getById(int id) throws ProductNotFound;
    public Product updateProduct(int id, Product product);
    public Product deleteProduct(int id);
    public Product addProduct(Product product);

    public List<Product> getAllProductSorted(String field);

    public Page<Product> getAllProductPage(int offset, int pageSize);

    public Page<Product> getAllProductAndSort(int offset , int pageSize , String field);
}
