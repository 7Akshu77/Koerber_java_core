package com.demo.bookapp.service;

import com.demo.bookapp.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    public List<Book> getAllBooks();

    public Book getBookById(int id) throws Throwable;

    public Book addBook(Book book);

    public Book updateBook(int id,Book book);

    public void deleteBookById(int id);

    public Book getByCategory(String category);
    public Page<Book> findAll(Pageable pageable);
    public void hello();
}
