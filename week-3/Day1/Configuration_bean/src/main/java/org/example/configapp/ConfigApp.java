package org.example.configapp;

import org.example.persistence.BookDaoImpl;
import org.example.service.ServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
@Configuration
@ComponentScan(basePackages = "org.example")
public class ConfigApp {
    @Bean
    public BookDaoImpl dao() {
        return new BookDaoImpl();
    }
    @Bean
    public ServiceImpl bs(BookDaoImpl dao) {
        return new ServiceImpl(dao);
    }


}
