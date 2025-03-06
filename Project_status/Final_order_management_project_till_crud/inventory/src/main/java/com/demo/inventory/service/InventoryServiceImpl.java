package com.demo.inventory.service;

import com.demo.inventory.entities.Inventory;
import com.demo.inventory.exceptions.ProductNotFound;
import com.demo.inventory.repository.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    private InventoryRepo inventoryRepo;

    @Autowired
    public InventoryServiceImpl(InventoryRepo inventoryRepo) {
        this.inventoryRepo = inventoryRepo;
    }

    @Override
    public List<Inventory> getAllProducts() {
        return inventoryRepo.findAll();
    }

    @Override
    public Inventory createProduct(Inventory inventory) {
        return inventoryRepo.save(inventory);
    }

    @Override
    public Inventory findByBarCode(String barCode) {
        Inventory inventory = inventoryRepo.findByBarCode(barCode);
        if(inventory== null){
            throw new ProductNotFound("Product not found");
        }
        return inventory;
    }

    @Override
    public int getQuantity(String barCode) {
        Inventory inventory = inventoryRepo.findByBarCode(barCode);
        if(inventory== null){
            throw new ProductNotFound("Product not found");
        }
        return inventory.getQuantity();
    }


    @Override
    public Inventory updateProduct(Inventory inventory) {
        Inventory inventory1;
        try{
            inventory1 = inventoryRepo.findByBarCode(inventory.getBarCode());
        }catch (Exception e){
            throw new ProductNotFound("Product not found");
        }
        inventory1.setQuantity(inventory.getQuantity());
        return inventoryRepo.save(inventory1);
    }

    @Override
    public void deleteProduct(String barCode) {
        try {
            Inventory inventory = inventoryRepo.findByBarCode(barCode);
            inventoryRepo.delete(inventory);
        }
       catch (Exception e){
           throw new ProductNotFound("Product not found");
       }

    }
}
