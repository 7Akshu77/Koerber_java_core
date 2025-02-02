package com.bankapp;

import com.bankapp.entity.Bank;
import com.bankapp.repo.BankRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(InfoDto.class)
public class BankApplication implements CommandLineRunner {
    @Autowired
    BankRepo bankRepo;

    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(BankApplication.class, args);
    }
    private Logger logger= LoggerFactory.getLogger(BankApplication.class);


    @Override
    public void run(String... args) throws Exception {
        logger.info("Application started");
        bankRepo.save(new Bank("Bank 1", 1000.0));
        bankRepo.save(new Bank("Bank 2", 2000.0));
    }
}
