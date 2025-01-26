package org.example.service;

import org.example.persistence.Book;

import java.util.List;

public interface Service {
    public List<Book> getAllBooks();
    public void addBook(Book book);
    public void deleteBook(int id);
    public void updateBook(int id, Book book);
    public Book getBookById(int id);

}
