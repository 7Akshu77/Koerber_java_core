package com.demo.bookapp.service;

import com.demo.bookapp.entities.Book;
import com.demo.bookapp.exception.BookNotFound;
import com.demo.bookapp.loggapp.Loggable;
import com.demo.bookapp.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookRepo repo;

    @Autowired
    public BookServiceImpl(BookRepo repo) {

        this.repo = repo;
    }

    @Override
    public List<Book> getAllBooks() {
        return repo.findAll();
    }
    @Override
    public Book getBookById(int id)  {
        return repo.findById(id).
                orElseThrow(()-> new BookNotFound("Book of id"+id+"not found"));
    }

    @Override
    public Book addBook(Book book) {
        repo.save(book);
        return book;
    }
    @Loggable
    @Override
    public Book updateBook(int id,Book book) {
        Book b1 = getBookById(id);
        b1.setIsbn(book.getIsbn());
        b1.setTitle(book.getTitle());
        b1.setCategory(book.getCategory());
        b1.setAuthor(book.getAuthor());
        b1.setPrice(book.getPrice());
        repo.save(b1);
        return b1;
    }
    @Loggable
    @Override
    public void deleteBookById(int id) {
        Book bootToRemove = getBookById(id);
        repo.delete(bootToRemove);
    }
    @Override
    public Book getByCategory(String category){
        return repo.getByCategory(category);
    }
    }
