package com.productapp.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends MongoRepository<Product, String> {
    @Query("{id:?0}")
    Optional<Product> getProdcutById(Integer id);

    @Query("{'qty':{'$lt':?0}}")
    List<Product> getProductsByQtyLessThan(Integer qty);

    @Query("{'qty':{'$gte':?0}}")
    List<Product> getProductdByQtyGreaterThanEqual(Integer qty);

    @Query("{ qty : ?0 }")
    List<Product> getProductsByQty(Integer qty);

    @Query("{'vendor':?0}")
    List<Product> getProductsByVendor(String vendor);

    @Query("{{'vendor':?0},{'cost':?1}}")
    List<Product> getProductsByVendorAndCost(String vendor, Double cost);

    @Query("{'$or':[{'vendor':?0},{'name':?1}]}")
    List<Product> getProductsByVendorOrName(String vendor, String name);

    @Query(value = "{'vendor':?0}", count = true)
    Integer getProductsCountByVendor(String vendor);

    @Query(value = "{'vendor':?0}", sort = "{'name':1}")
    List<Product> getProductsByVendorSortByName(String vendor);

    @Query(value = "{'qty':?0}", fields = "{'name':1,'vendor':1}")
    List<Product> getProductNameAndVendorByQty(Integer qty);

    @Query(value = "{'vendor:?0'}")
    List<Product> getAllProductByVendor(String vendor);

    @Query("{'vendor':{$regex:?0}}")
    List<Product> getProductsByVendorRegEx(String vendor);


}
