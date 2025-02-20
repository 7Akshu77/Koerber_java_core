package com.productapp.controller;

import com.productapp.repo.Product;
import com.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
    this.productService = productService;
}

@GetMapping("all")
    public List<Product> findAll(){
        return productService.findAll();
}
@GetMapping("/id/{id}")
    public Product findById(@PathVariable String id){
        return productService.findById(id);
}
@GetMapping("name_cost/{id}")
    public Product findAndModifyNameAndCost(@PathVariable String id ,@RequestBody String name, @RequestBody Double cost){
        return productService.findAndModifyNameAndCost(id, name, cost);
}
@GetMapping("multi")
    public void multiUpdate(){
        productService.multiUpdate();
}
@DeleteMapping("remove/{cost}")
    public void findAndRemove(@PathVariable Double cost){
        productService.findAndRemove(cost);
}
@DeleteMapping("removeAll/{cost}")
    public void findAllAndRemove(@PathVariable Double cost){
        productService.findAllAndRemove(cost);
}
@PutMapping("upsert/{id}")
    public void upsert(@PathVariable String id ,@RequestBody String name, @RequestBody Double cost){
        productService.upsert(id, name, cost);
}

    @GetMapping("/qty/gt")
    public void findProductsByQtysGreaterThan( @PathVariable int qty){
        productService.findProductsByQtysGreaterThan(qty);
    }

    @GetMapping("/vendor/{vendor}")
    public void findProductsByVendor(@PathVariable String vendor){
        productService.findProductsByVendor(vendor);
    }

}
