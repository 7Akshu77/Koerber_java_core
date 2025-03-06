package com.demo.productapp.controller;

import com.demo.productapp.entities.Product;
import com.demo.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @GetMapping("products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("products/barcode/{barCode}")
    public ResponseEntity<Product> getProductByBarcode(@PathVariable String barCode) {
        return ResponseEntity.ok(productService.getByBarcode(barCode));
    }
    @PutMapping("products")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(product));
    }

    @PostMapping("products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @DeleteMapping("products/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }
    @DeleteMapping("products/{barcode}")
    public void deleteProductByBarcode(@PathVariable String Barcode) {
       productService.deleteByBarcode(Barcode);
    }


}
