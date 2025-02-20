package com.productapp.service;

import com.productapp.repo.Product;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<Product> getAll();
    public Product save(Product product);
    public Product update(String id, Product product);
    public void delete(String id);
    public Product getById(String id);

    Optional<Product> getProdcutById(Integer id);

    List<Product> getProductsByQtyLessThan(Integer qty);

    List<Product> getProductdByQtyGreaterThanEqual(Integer qty);


    List<Product> getProductsByQty(Integer qty);


    List<Product> getProductsByVendor(String vendor);

    List<Product> getProductsByVendorAndCost(String vendor, Double cost);


    List<Product> getProductsByVendorOrName(String vendor, String name);

    Integer getProductsCountByVendor(String vendor);

    List<Product> getProductsByVendorSortByName(String vendor);

    List<Product> getProductNameAndVendorByQty(Integer qty);

    List<Product> getAllProductByVendor(String vendor);

    List<Product> getProductsByVendorRegEx(String vendor);
}
