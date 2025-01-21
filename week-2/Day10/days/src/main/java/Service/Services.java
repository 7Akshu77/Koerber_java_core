package Service;

import Repo.DaoException.Book;
import Repo.DaoException.DaoException;

import java.util.List;

public interface Services {
    public List<Book> getAllBooks()throws DaoException;
    public Book addBook(Book book) throws DaoException;
    public void deleteBook(int id) throws DaoException;
    public void updateBook(int id, Book book) throws DaoException;
    public Book getBookById(int id) throws DaoException;
}
