package com.demo.orderapp.serviceproxy;

import com.demo.orderapp.dto.ProductBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "productapp", url = "http://localhost:8000/")
public interface ProductServiceProxy {

    @GetMapping("products/barcode/{barCode}")
    public ProductBean getProductByBarcode(@PathVariable String barCode);

    @DeleteMapping("products/{barcode}")
    void deleteProductByBarcode(@PathVariable String barCode);

}