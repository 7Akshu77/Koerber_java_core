package com.productapp.productapp.controller;

import com.productapp.productapp.entities.Product;
import com.productapp.productapp.repo.ProductRepo;
import com.productapp.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ProductController {

    private ProductRepo repo;

    private ProductService service;

    @Autowired
    public ProductController(ProductService service, ProductRepo repo) {
        this.service = service;
        this.repo = repo;
    }

    @GetMapping("/products")
    public List<Product> getAllProduct() {
        return service.getAllProduct();
    }

    @GetMapping("/products/{id}")
    public Product getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PutMapping("/products/update/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        return service.updateProduct(id, product);
    }

    @PostMapping("/products/add")
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @DeleteMapping("/products/delete/{id}")
    public Product deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }

    @GetMapping("products/list")
    public List<Product> getListOfAllProducts() {
        return repo.getListOfAllProducts();
    }

    @GetMapping("products/list/{name}")
    public List<Product> getListOfAllProductsBasedOnName(@PathVariable String name) {
        return repo.getListOfAllProductsBasedOnName(name);

    }

    @GetMapping("products/list/{name}/{price}")
    public List<Product> getNameAndPrice(@PathVariable String name, @PathVariable BigDecimal price) {
        return repo.getListOfAllProductsBasedOnNameAndPrice(name, price);
    }

    @GetMapping("products/sort/{field}")
    public List<Product> getAllProductSorted(@PathVariable String field) {
        return service.getAllProductSorted(field);
    }
    @GetMapping("products/page/{offset}/{pageSize}")
    public Page<Product> getAllProductPage(@PathVariable int offset, @PathVariable int pageSize) {
        return service.getAllProductPage(offset, pageSize);
    }

    @GetMapping("products/page/{offset}/{pageSize}/{field}")
    public Page<Product> getAllProductAndSort(@PathVariable int offset, @PathVariable int pageSize , @PathVariable String field) {
        return service.getAllProductAndSort(offset, pageSize , field);
    }
}
