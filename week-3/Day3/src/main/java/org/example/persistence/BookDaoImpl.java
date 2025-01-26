package org.example.persistence;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.logging.Logger;

public class BookDaoImpl implements BookDao{
    private static Logger logger = Logger.getLogger(BookDaoImpl.class.getName());

    private final JdbcTemplate jdbcTemplate;

    public BookDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate  = jdbcTemplate;
    }
    @Override
    public List<Book> getAllBooks() {
        return jdbcTemplate.query("select * from book", new BookRowMapper());
    }

    @Override
    public void addBook(Book book) {
         jdbcTemplate.update("insert into book(id,isbn,author,title,price) values(?,?,?,?,?)",
                new Object[]{book.getId(),
                book.getIsbn(),book.getAuthor(),book.getTitle(),book.getPrice()});
    }
    @Override
    public int deleteBook(int id) {
        return jdbcTemplate.update("delete from Book where id = ?",id);
    }

    @Override
    public int updateBook(int id, Book book) {
        return jdbcTemplate.update("update Book set isbn = ?, author = ?, title = ?, price = ? where id = ?",
                new Object[]{book.getIsbn(),book.getAuthor(),book.getTitle(),book.getPrice(),id});
    }

    @Override
    public Book getBookById(int id) {

        return (Book) jdbcTemplate.queryForObject("select * from Book where id = ?",
                new Object[]{id}, new BookRowMapper());
    }

}
