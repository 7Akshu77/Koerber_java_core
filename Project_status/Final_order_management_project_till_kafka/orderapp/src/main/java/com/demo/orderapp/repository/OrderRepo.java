package com.demo.orderapp.repository;

import com.demo.orderapp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface OrderRepo extends JpaRepository<Order, Integer> {
    public Order findByBarCode(String barCode);
    public void deleteByBarCode(String barCode);
}
