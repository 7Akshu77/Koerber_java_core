package com.demo.inventory.controller;

import com.demo.inventory.entities.Inventory;
import com.demo.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController {

    private InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("inventory")
    public ResponseEntity<List<Inventory>> getAllItems() {
        return ResponseEntity.ok(inventoryService.getAllProducts());
    }

    @GetMapping("inventory/{barCode}")
    public ResponseEntity<Inventory> getItem(@PathVariable String barCode) {
        return ResponseEntity.ok(inventoryService.findByBarCode(barCode));
    }

    @GetMapping("inventory/quantity/{barCode}")
    public ResponseEntity<Integer> getItemQuantity(@PathVariable String barCode) {
        return ResponseEntity.ok(inventoryService.findByBarCode(barCode).getQuantity());
    }
    @PostMapping("inventory")
    public ResponseEntity<Inventory> addItem(@RequestBody Inventory inventory) {
        return ResponseEntity.ok(inventoryService.createProduct(inventory));
    }

    @PutMapping("inventory")
    public ResponseEntity<Inventory> updateItem(@RequestBody Inventory inventory) {
        return ResponseEntity.ok(inventoryService.updateProduct(inventory));
    }


    @DeleteMapping("inventory/{barCode}")
    public void deleteItem(@PathVariable String barCode) {
        inventoryService.deleteProduct(barCode);
    }

}
