package com.demo.inventory.service;

import com.demo.inventory.entities.Inventory;

import java.util.List;

public interface InventoryService {
    public List<Inventory> getAllProducts();
    public Inventory createProduct(Inventory inventory);
    public Inventory updateProduct(Inventory inventory);
    public void deleteProduct(String barCode);
    public Inventory findByBarCode(String barCode);
    public int getQuantity(String barCode);


}
