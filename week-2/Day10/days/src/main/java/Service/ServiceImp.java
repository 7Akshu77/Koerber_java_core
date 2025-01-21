package Service;

import Repo.DaoException.Book;
import Repo.DaoException.BookDao;
import Repo.DaoException.DaoException;
import Repo.DaoException.DaoImpl.DaoImpl;

import java.util.List;

public class ServiceImp implements Services {
     BookDao dao = new DaoImpl();

    @Override
    public List<Book> getAllBooks() throws DaoException {
       return dao.getAllBooks();
    }

    @Override
    public Book addBook(Book book) throws DaoException {
        return dao.addBook(book);
    }

    @Override
    public void deleteBook(int id) throws DaoException {
     dao.deleteBook(id);
    }

    @Override
    public void updateBook(int id, Book book) throws DaoException {
          dao.updateBook(id,book);
    }

    @Override
    public Book getBookById(int id) throws DaoException {
        Book book =dao.getBookById(id);
        if(book == null){
            throw new DaoException("Book not found");
        }
        else{
            return book;
        }
    }
}
