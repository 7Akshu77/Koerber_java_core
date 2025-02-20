package com.productapp.service;

import com.productapp.repo.Product;
import com.productapp.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private MongoTemplate mongoTemplate;

    @Autowired
    public ProductServiceImpl(MongoTemplate mongoTemplate){
this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Product> findAll() {
        return mongoTemplate.findAll(Product.class);
    }

    @Override
    public Product findById(String id) {
        return Optional.ofNullable(mongoTemplate.findById(id, Product.class))
                .orElseThrow(()->new RuntimeException());
    }

    @Override
    public Product findAndModifyNameAndCost(String id, String name, Double cost) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("name", name);
        update.set("cost", cost);
        mongoTemplate.findAndModify(query, update, Product.class);
        Product pro = findById(id);
        return pro;
    }

    @Override
    public void multiUpdate() {
        Query query = new Query(Criteria.where("qty").lt(20));
        Update update = new Update();
        update.set("cost",1000);
        mongoTemplate.updateMulti(query, update, Product.class);
        System.out.println("update success");
    }

    @Override
    public void findAndRemove(Double cost) {
        Query query = new Query(Criteria.where("cost").is(cost));
        Update update = new Update();
        mongoTemplate.findAndRemove(query, Product.class);
        System.out.println("deleted");
    }

    @Override
    public void findAllAndRemove(Double cost) {
        Query query = new Query(Criteria.where("cost").is(cost));
        Update update = new Update();
        mongoTemplate.findAllAndRemove(query, Product.class);
        System.out.println("deleted");
    }

    @Override
    public void upsert(String id , String name , Double cost) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("cost", cost);
        update.set("name", name);
        mongoTemplate.upsert(query, update,Product.class);

    }

    @Override
    public void findProductsByVendor(String vendor) {
        Query query = new Query(Criteria.where("vendor").is(vendor));
        Update update = new Update();
        mongoTemplate.find(query, Product.class);
        System.out.println("found");
    }

    @Override
    public void findProductsByQtysGreaterThan(int qty) {
        Query query = new Query(Criteria.where("qty").gt(qty));
        Update update = new Update();
        mongoTemplate.find(query, Product.class);
        System.out.println("done");
    }
}
