package com.demo.productapp.service;

import com.demo.productapp.entities.Product;
import com.demo.productapp.exception.ProductNotFound;
import com.demo.productapp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product getProductById(int id){
        return productRepo.findById(id).orElseThrow(()-> new ProductNotFound("Product not found"));
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product new_product = productRepo.findById(product.getId()).orElseThrow(()-> new ProductNotFound("Product not found"));
        new_product.setName(product.getName());
        new_product.setDescription(product.getDescription());
        new_product.setPrice(product.getPrice());
        new_product.setBarCode(product.getBarCode());
        new_product.setMfg(product.getMfg());
        return productRepo.save(new_product);
    }

    @Override
    public void deleteProduct(int id) {
        Product product = productRepo.findById(id).orElseThrow(()-> new ProductNotFound("Product not found"));
        productRepo.deleteById(id);
    }
    @Override
    public Product getByBarcode(String barCode){
        Product product =  productRepo.findByBarCode(barCode);
        if(product == null) throw new ProductNotFound("Product not found");
        return product;
    }
    @Override
    public Product deleteByBarcode(String barCode){
        Product product = productRepo.findByBarCode(barCode);
        productRepo.delete(product);
        return product;
    }
}
