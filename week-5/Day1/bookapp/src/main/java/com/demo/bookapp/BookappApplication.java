package com.demo.bookapp;

import com.demo.bookapp.dto.UserEntity;
import com.demo.bookapp.repo.BookRepo;
import com.demo.bookapp.service.BookService;
import com.demo.bookapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.List;

@EnableScheduling
@SpringBootApplication
public class BookappApplication  implements CommandLineRunner{

	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	UserService userService;
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
		repo.save(new com.demo.bookapp.entities.Book("1234","book1","category1","author1",BigDecimal.valueOf(150)));
		repo.save(new com.demo.bookapp.entities.Book("1235","book2","category2","author2",BigDecimal.valueOf(200)));
		repo.save(new com.demo.bookapp.entities.Book("1236","book3","category3","author3",BigDecimal.valueOf(250)));
		repo.save(new com.demo.bookapp.entities.Book("1237","book4","category4","author4",BigDecimal.valueOf(300)));
		System.out.println("----------product is added------");
			userService.addUserEntity(new UserEntity("teacher",
					passwordEncoder.encode("te123"), List.of("ROLE_ADMIN","ROLE_GEN")));

			userService.addUserEntity(new UserEntity("student",passwordEncoder.encode("st123"),
					List.of("ROLE_GEN")));
			System.out.println("----------------user added-----------------");

		}
	}

