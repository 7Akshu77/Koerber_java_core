package com.demo.productapp;

import com.demo.productapp.entities.Product;
import com.demo.productapp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class ProductappApplication implements CommandLineRunner {

	@Autowired
	ProductRepo productRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProductappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productRepo.save(new Product(1, " Dell Laptop", "Dell Laptop A10 series", "electronics",100000, "A15B7", new Date(2023,12,4)));
		productRepo.save(new Product(2, "Samsung Mobile", "Samsung Mobile A10 series", "electronics",50000, "A12B8", new Date(2024,2,14)));
	}
}
