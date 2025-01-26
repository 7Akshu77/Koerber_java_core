package org.example.persistence;

import java.util.List;

public interface BookDao {
    public List<Book> getAllBooks();
    public void addBook(Book book);
    public int deleteBook(int id);
    public int updateBook(int id, Book book);
    public Book getBookById(int id);

}
