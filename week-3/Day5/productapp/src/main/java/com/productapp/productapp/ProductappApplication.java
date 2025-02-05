package com.productapp.productapp;

import com.productapp.productapp.entities.Product;
import com.productapp.productapp.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@SpringBootApplication
public class ProductappApplication implements CommandLineRunner {
	@Autowired
	ProductRepo repo;

	public static void main(String[] args) {

		SpringApplication.run(ProductappApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("---------------------------------");
//		List<Product> products= IntStream.rangeClosed(1, 4000)
//				.mapToObj(i->
//						new Product("product "+i, BigDecimal.valueOf(new Random().nextDouble(5000))))
//				.toList();
//		repo.saveAll(products);
//		repo.save(new Product("Laptop",new BigDecimal(10000)));
//		repo.save(new Product("Mobile",new BigDecimal(25000)));
	}

}
