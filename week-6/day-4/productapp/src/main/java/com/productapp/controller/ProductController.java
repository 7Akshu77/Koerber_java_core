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
@GetMapping("/all")
    public ResponseEntity<List<Product>> getALL(){
        return ResponseEntity.ok(productService.getAll());
}
@PostMapping("/add")
    public ResponseEntity<Product> addProduct( @RequestBody Product product){
        return ResponseEntity.ok(productService.save(product));
}
@PutMapping("/update/{id}")
    public ResponseEntity<Product> update(@PathVariable String id , @RequestBody Product product){
        return ResponseEntity.ok(productService.update(id, product));
}
@DeleteMapping("/delete/{id}")
    public void deleteproduct(@PathVariable String id){
         productService.delete(id);
    System.out.println("deleted successfully");
}
@GetMapping("/qty")
    public ResponseEntity<List<Product>> getProductsByQtyLessThan(@PathVariable Integer qty){
        return ResponseEntity.ok(productService.getProductsByQtyLessThan(qty));
}
    @GetMapping("/qty/gte")
    public ResponseEntity<List<Product>> getProductsByQtyGraterThanEqual(@PathVariable Integer qty){
        return ResponseEntity.ok(productService.getProductdByQtyGreaterThanEqual(qty));
    }

    @GetMapping("/vendor/{vendor}")
    public ResponseEntity<List<Product>> getProductdByVendor(@PathVariable String vendor){
        return ResponseEntity.ok(productService.getAllProductByVendor(vendor));
    }
    @GetMapping("/vendor/{vendor}/cost/{cost}")
    public ResponseEntity<List<Product>> getProductsByVendorAndCost(@PathVariable String vendor,@PathVariable Double cost){
        return ResponseEntity.ok(productService.getProductsByVendorAndCost(vendor,cost));
    }
}
