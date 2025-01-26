package org.example.configapp;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "org.example")
@EnableAspectJAutoProxy
@PropertySource("dbconn.properties")
public class ConfigApp {
    @Value("${db.driverClassName}")
    private String driverClassName;
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    @Bean
    DriverManagerDataSource ds(){
        DriverManagerDataSource dmds = new DriverManagerDataSource();
        dmds.setDriverClassName(driverClassName);
        dmds.setUrl(url);
        dmds.setUsername(username);
        dmds.setPassword(password);
        return dmds;
    }
    @Bean
    DataSourceTransactionManager transactionManager(DataSource ds ){
        DataSourceTransactionManager dtm = new DataSourceTransactionManager(ds);
        return dtm;
    }
    @Bean
    JdbcTemplate jdbcTemplate(DataSource ds){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
        return jdbcTemplate;
    }
//    @Bean
//    public LoggingAspect loggingAspect() {
//        return new LoggingAspect();
//    }


}
