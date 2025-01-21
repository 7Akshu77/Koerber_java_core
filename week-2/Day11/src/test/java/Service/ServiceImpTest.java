package Service;

import Repo.DaoException.Book;
import Repo.DaoException.BookDao;
import Repo.DaoException.DaoException;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServiceImpTest {
    @Mock
    BookDao dao;
    @InjectMocks
    Services services;

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws DaoException {
        List<Book> books= List.of(new Book(1,"jdw321","Verity","Collen Hover",300),
                new Book(2,"jdw322","Atomic habits","James Clear",300),
                new Book(3,"jdw323","Power of positive thinking","H D Carroll",300),
                new Book(4,"jdw324","Shatter me "," Tahiri",300),
                new Book(5,"jdw325","Why has no one told me","Marianne Williamson",300));
        when(dao.getAllBooks()).thenReturn(books);
    }
    @Test
    public void getAllBooks() throws DaoException {
        List<Book> books  = services.getAllBooks();
        assertEquals(5,books.size());

    }
    @Test
    public void addBook() throws DaoException{
        Book book = new Book(6,"jdw326","Power of positive thinking","H D Carroll",300);
        Book b1 = services.addBook(book);
        assertNotNull(book);
        assertEquals(book , b1);
    }
    @Test
    public void deleteBook() throws DaoException{
        services.deleteBook(1);
        assertEquals(4,services.getAllBooks().size());
    }
    @Test
    public void updateBook() throws DaoException{
        Book b1 = new Book(1,"jdw321","Verity","Collen Hover",400);
        services.updateBook(1,b1);
        assertEquals(b1, services.getBookById(1));
    }

}