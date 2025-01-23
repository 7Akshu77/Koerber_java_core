package org.example.service;

import org.example.persistence.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.example.persistence.BookDao;
import java.util.List;
import org.example.persistence.Book;
@Component(value = "bs")
public class ServiceImpl implements Service {

BookDao dao;
    @Autowired
    public void setDao(BookDao dao) {
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
