package com.demo.bookapp;

import com.demo.bookapp.repo.BookRepo;
import com.demo.bookapp.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.math.BigDecimal;

@SpringBootApplication
public class BookappApplication  implements CommandLineRunner{
	@Autowired
	BookRepo repo;

	@Autowired
	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private Logger logger= LoggerFactory.getLogger(BookappApplication.class);

	public static void main(String[] args){
		SpringApplication.run(BookappApplication.class, args);
	}
		@Override
		public void run(String... args) throws Exception {


		logger.info("product app is started");
//		repo.save(new com.demo.bookapp.entities.Book("1234","book1","category1","author1",BigDecimal.valueOf(150)));
//		repo.save(new com.demo.bookapp.entities.Book("1235","book2","category2","author2",BigDecimal.valueOf(200)));
//		System.out.println("----------product is added------");
		}
	}

