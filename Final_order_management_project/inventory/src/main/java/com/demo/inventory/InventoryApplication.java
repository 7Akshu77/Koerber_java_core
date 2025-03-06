package com.demo.inventory;

import com.demo.inventory.entities.Inventory;
import com.demo.inventory.repository.InventoryRepo;
import com.demo.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventoryApplication implements CommandLineRunner {
	@Autowired
	InventoryRepo inventoryRepo;

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//inventoryRepo.save(new Inventory(1, 100, "A15B7"));
		//inventoryRepo.save(new Inventory(2, 50, "A15B8"));
	}
}
