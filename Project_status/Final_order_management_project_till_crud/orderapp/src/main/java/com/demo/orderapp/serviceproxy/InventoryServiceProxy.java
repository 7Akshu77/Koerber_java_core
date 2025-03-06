package com.demo.orderapp.serviceproxy;

import com.demo.orderapp.dto.InventoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "inventoryapp", url = "http://inventory-service:8002/")
public interface InventoryServiceProxy {

    @GetMapping("inventory/{barCode}")
    public InventoryDto getItem(@PathVariable String barCode);

    @GetMapping("inventory/quantity/{barCode}")
    public Integer getItemQuantity(@PathVariable String barCode);

    @PutMapping("inventory")
    public InventoryDto updateItem(@RequestBody InventoryDto inventory);
}
