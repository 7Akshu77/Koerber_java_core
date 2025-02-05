package com.productapp.productapp.service;

import com.productapp.productapp.entities.Product;
import com.productapp.productapp.exception.ProductNotFound;
import com.productapp.productapp.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo repo;

    @Override
    public List<Product> getAllProduct() {
        return repo.findAll();
    }


    @Override
    public Product getById(int id) {
        return repo.findById(id).orElseThrow(() -> new ProductNotFound("Product not found with id " + id));
    }

    @Override
    public Product updateProduct(int id, Product product) {
        Product product1 = getById(id);
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        return repo.save(product1);
    }

    @Override
    public Product deleteProduct(int id) {
        Product product = getById(id);
        repo.delete(product);
        return product;
    }

    @Override
    public Product addProduct(Product product) {
        return repo.save(product);
    }

    public List<Product> getListOfAllProducts() {
        return repo.findAll();
    }

    public List<Product> getListOfAllProductsBasedOnName(String name){
        return repo.getListOfAllProductsBasedOnName(name);
    }
    public List<Product> nameAndPrice(String name, BigDecimal price){
        return repo.getListOfAllProductsBasedOnNameAndPrice(name, price);
    }
    @Override
    public List<Product> getAllProductSorted(String field) {
        return repo.findAll(Sort.by(field));
    }

    @Override
    public Page<Product> getAllProductPage(int offset, int pageSize) {
        return repo.findAll(PageRequest.of(offset, pageSize));
    }
    @Override
    public Page<Product> getAllProductAndSort(int offset , int pageSize , String field){
        return repo.findAll(PageRequest.of(offset, pageSize, Sort.by(field)));
    }
}

