package com.demo;

import com.demo.dao.Account;
import com.demo.repo.AccountRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
@SpringBootApplication
public class AccountApplication implements CommandLineRunner{
    @Autowired
    AccountRepo accountRepo;

    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(com.demo.AccountApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        accountRepo.save(new Account("Ram",  BigDecimal.valueOf(1000.0)));
//        accountRepo.save(new Account("Shyam", BigDecimal.valueOf(2000.0)));
//        accountRepo.save(new Account("Hari", BigDecimal.valueOf(3000.0)));

    }
}
