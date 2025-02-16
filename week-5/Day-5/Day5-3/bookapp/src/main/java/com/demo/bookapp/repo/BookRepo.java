package com.demo.bookapp.repo;

import com.demo.bookapp.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, Integer> {

}
