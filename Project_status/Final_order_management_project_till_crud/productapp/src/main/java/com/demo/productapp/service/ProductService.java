package com.demo.productapp.service;

import com.demo.productapp.entities.Product;
import com.demo.productapp.exception.ProductNotFound;

import java.util.List;

public interface ProductService {
    public Product getProductById(int id) throws ProductNotFound;
    public List<Product> getAllProduct();
    public Product getByBarcode(String barCode);
    public Product addProduct(Product product);
    public Product updateProduct(Product product);
    public void deleteProduct(int id) throws ProductNotFound;
    public Product deleteByBarcode(String barCode);

}
