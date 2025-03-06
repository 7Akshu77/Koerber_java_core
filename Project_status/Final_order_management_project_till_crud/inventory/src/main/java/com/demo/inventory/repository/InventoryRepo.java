package com.demo.inventory.repository;

import com.demo.inventory.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;



public interface InventoryRepo extends JpaRepository<Inventory, Integer> {
    public Inventory findByBarCode(String barCode);
}
