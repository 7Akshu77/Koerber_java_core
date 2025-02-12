package com.demo.bookapp.controller;

import com.demo.bookapp.dto.AuthRequest;
import com.demo.bookapp.entities.Book;
import com.demo.bookapp.service.BookService;
import com.demo.bookapp.service.JwtService;
import jakarta.persistence.PostUpdate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

public class BookController {

    private BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping(path = "home")
    public String home() {
        return "home ";
    }

    @PostMapping(path = "authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {

        Authentication authentication
                = authenticationManager.
                authenticate(new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword()
                ));

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("user is invalid");
        }


    }


        @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', ROLE_GEN) ")
    @GetMapping(path = "books")
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', ROLE_GEN) ")
    @GetMapping(path = "books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) throws Throwable{
        Book book = bookService.getBookById(id);
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

        @PreAuthorize("hasAuthority('ROLE_ADMIN')")
        @PostMapping(path = "books/add")
    public ResponseEntity<Book> addBook(@RequestBody @Valid Book book){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addBook(book));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping(path = "books/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.updateBook(id,book));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(path = "books/delete/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable int id){
        bookService.deleteBookById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Book deleted successfully");
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', ROLE_GEN) ")
    @GetMapping(path = "books/category/{category}")
    public ResponseEntity<Book> getByCategory(@PathVariable String category){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getByCategory(category));
    }
}
