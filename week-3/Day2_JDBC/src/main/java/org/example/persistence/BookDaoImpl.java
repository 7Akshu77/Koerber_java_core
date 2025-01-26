package org.example.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao{
    private static Logger logger = Logger.getLogger(BookDaoImpl.class.getName());
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public BookDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate  = jdbcTemplate;
    }

    @Override
    public List<Book> getAllBooks() {

        return jdbcTemplate.query("select * from book", new BookRowMapper());
    }

    @Override
    public Book addBook(Book book) {
        jdbcTemplate.update("insert into book(id,isbn,author,title,price) values(?,?,?,?,?)",
                new Object[]{book.getId(),
                        book.getIsbn(),book.getAuthor(),book.getTitle(),book.getPrice()});
        return book;
    }
    @Override
    public void deleteBook(int id) {
         jdbcTemplate.update("delete from Book where id = ?",id);
    }

    @Override
    public void updateBook(int id, Book book) {

        jdbcTemplate.update("update Book set isbn = ?, author = ?, title = ?, price = ? where id = ?",
                new Object[]{book.getIsbn(),book.getAuthor(),book.getTitle(),book.getPrice(),id});
    }

    @Override
    public Book getBookById(int id) {

        return (Book) jdbcTemplate.queryForObject("select * from Book where id = ?",
                new Object[]{id}, new BookRowMapper());
    }

}
