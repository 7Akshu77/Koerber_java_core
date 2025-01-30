package com.demo.bookapp.controller;

import com.demo.bookapp.entities.Book;
import com.demo.bookapp.service.BookService;
import jakarta.persistence.PostUpdate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

public class BookController {

    private BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path = "books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
    }

    @GetMapping(path = "books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) throws Throwable{
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBookById(id));
    }

    @PostMapping(path = "books")
    public ResponseEntity<Book> addBook(@RequestBody @Valid Book book){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addBook(book));
    }

    @PutMapping(path = "books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.updateBook(id,book));
    }

    @DeleteMapping(path = "books/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable int id){
        bookService.deleteBookById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Book deleted successfully");
    }
}
