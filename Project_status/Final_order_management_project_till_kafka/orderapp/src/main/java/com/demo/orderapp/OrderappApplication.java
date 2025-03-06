package com.demo.orderapp;

import com.demo.orderapp.entity.Address;
import com.demo.orderapp.entity.Order;
import com.demo.orderapp.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Date;

@EnableFeignClients
@SpringBootApplication
public class OrderappApplication {
	@Autowired
	private OrderRepo orderRepo;

	public static void main(String[] args) {
		SpringApplication.run(OrderappApplication.class, args);
	}

}
