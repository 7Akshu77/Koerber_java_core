package com.productapp.service;

import com.productapp.repo.Product;
import com.productapp.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo){
        this.productRepo  = productRepo;
    }
    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product update(String id, Product book) {
        Product pro = getById(id);
        pro.setCost(book.getCost());
        pro.setName(book.getName());
        pro.setQty(book.getQty());
        pro.setVendor(book.getVendor());
        productRepo.save(pro);
        return pro;
    }

    @Override
    public void delete(String id) {
        productRepo.delete(getById(id));
    }

    @Override
    public Product getById(String id) {
        return productRepo.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Optional<Product> getProdcutById(Integer id){
        return productRepo.getProdcutById(id);
    }

    public List<Product> getProductsByQtyLessThan(Integer qty)
    {
        return productRepo.getProductsByQtyLessThan(qty);
    }

    public List<Product> getProductdByQtyGreaterThanEqual(Integer qty){
        return productRepo.getProductdByQtyGreaterThanEqual(qty);
    }


    public List<Product> getProductsByQty(Integer qty){
        return productRepo.getProductsByQty(qty);
    }


    public List<Product> getProductsByVendor(String vendor){
        return productRepo.getProductsByVendor(vendor);
    }

    public List<Product> getProductsByVendorAndCost(String vendor, Double cost){
        return productRepo.getProductsByVendorAndCost(vendor, cost);
    }


    public List<Product> getProductsByVendorOrName(String vendor, String name){
        return productRepo.getProductsByVendorOrName(vendor,name);
    }

    public Integer getProductsCountByVendor(String vendor){
        return productRepo.getProductsCountByVendor(vendor);
    }

    public List<Product> getProductsByVendorSortByName(String vendor){
        return productRepo.getProductsByVendorSortByName(vendor);
    }

    public List<Product> getProductNameAndVendorByQty(Integer qty){
        return productRepo.getProductNameAndVendorByQty(qty);
    }

    public List<Product> getAllProductByVendor(String vendor){
        return productRepo.getAllProductByVendor(vendor);
    }

    public List<Product> getProductsByVendorRegEx(String vendor){
        return productRepo.getProductsByVendorRegEx(vendor);
    }
}
