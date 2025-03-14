package org.example.service;

import org.example.aspect.Loggable;
import org.example.persistence.BookDao;

import java.util.List;
import org.example.persistence.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@org.springframework.stereotype.Service(value = "bs")
public class ServiceImpl implements Service {
private BookDao dao;
    @Autowired
   public ServiceImpl(BookDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Book> getAllBooks() {
        return dao.getAllBooks();
    }

    @Override
    public Book addBook(Book book) {
        return dao.addBook(book);
    }

    @Loggable
    @Override
    public void deleteBook(int id) {
        dao.deleteBook(id);
    }

    @Override
    public void updateBook(int id, Book book) {
        dao.updateBook(id, book);
    }

    @Override
    public Book getBookById(int id) {
        return dao.getBookById(id);
    }


}
