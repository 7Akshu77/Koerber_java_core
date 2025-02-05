package com.demo.bookapp.controller;

import com.demo.bookapp.entities.Book;
import com.demo.bookapp.representationalmodel.BookModel;
import com.demo.bookapp.service.BookService;
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
    public Page<Book> getBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return bookService.findAll(pageable);
    }


    @GetMapping(path = "books/{id}")
    public ResponseEntity<BookModel> getBookById(@PathVariable int id) throws Throwable{
        Book book = bookService.getBookById(id);

        BookModel bookModel = new BookModel(book.getId(), book.getIsbn() ,book.getTitle(), book.getAuthor(), book.getPrice());

        // Adding HATEOAS links
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class)
                .getBookById(id)).withSelfRel();
        Link allBooksLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class)
                .getBooks(0,2)).withRel("all_books");
        Link updateLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class)
                .updateBook(id,book)).withRel("update_book");

        bookModel.add(selfLink, allBooksLink , updateLink);
        return ResponseEntity.status(HttpStatus.OK).body(bookModel);
    }

    //    @PostMapping(path = "books")
//    public ResponseEntity<Book> addBook(@RequestBody @Valid Book book){
//        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addBook(book));
//    }
//
    @PutMapping(path = "books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.updateBook(id,book));
    }

//
//    @DeleteMapping(path = "books/{id}")
//    public ResponseEntity<String> deleteBookById(@PathVariable int id){
//        bookService.deleteBookById(id);
//        return ResponseEntity.status(HttpStatus.OK).body("Book deleted successfully");
//    }
//    @GetMapping(path = "books/category/{category}")
//    public ResponseEntity<Book> getByCategory(@PathVariable String category){
//        return ResponseEntity.status(HttpStatus.OK).body(bookService.getByCategory(category));
//    }
}
