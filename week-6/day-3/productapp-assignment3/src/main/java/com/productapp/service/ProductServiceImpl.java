package com.productapp.service;

import com.productapp.repo.Product;
import com.productapp.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo){
        this.productRepo  = productRepo;
    }
    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product update(String id, Product book) {
        Product pro = getById(id);
        pro.setCost(book.getCost());
        pro.setName(book.getName());
        pro.setQty(book.getQty());
        pro.setVendor(book.getVendor());
        productRepo.save(pro);
        return pro;
    }

    @Override
    public void delete(String id) {
        productRepo.delete(getById(id));
    }

    @Override
    public Product getById(String id) {
        return productRepo.findById(id).orElseThrow(RuntimeException::new);
    }
}
