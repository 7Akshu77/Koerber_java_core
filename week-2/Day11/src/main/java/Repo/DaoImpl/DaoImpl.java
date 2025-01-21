package Repo.DaoException.DaoImpl;
import Connection.FactoryConnect;
import Repo.DaoException.Book;
import Repo.DaoException.BookDao;
import Repo.DaoException.DaoException;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DaoImpl  implements BookDao {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(DaoImpl.class);
    public Logger logger = Logger.getLogger(DaoImpl.class.getName());
    private static Connection connection ;

    public DaoImpl() {
        this.connection = FactoryConnect.getConnection();
    }

    @Override
        public List<Book> getAllBooks() throws DaoException {
            List<Book> book = new ArrayList<>();
            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from Book");
                while (rs.next()) {
                    book.add(new Book(rs.getInt(1),
                            rs.getString(2), rs.getString(3),
                            rs.getString(4), rs.getDouble(5)));
                }
                // using log
            if(book.isEmpty()){
                log.error("No books found");
            }
            else {
                log.info("All books found");
            }
            } catch (SQLException e) {
                throw new DaoException("some dao exception ",e);
            }

        return book;
        }

        @Override
        public void deleteBook (int id) throws DaoException {
            Book book = null;
            try {
                PreparedStatement ps = connection.prepareStatement("delete from  book where id =?");
                ps.setInt(1,id);
                ps.executeUpdate();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            log.info("book deleted successfully");
        }

        @Override
        public Book getBookById ( int id) throws DaoException {
            Book book = null;
            try{
                PreparedStatement ps = connection.prepareStatement("select * from Book where id = ?");
                ps.setInt(1,id);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    book = new Book(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),
                    rs.getDouble(5));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return book;
        }

        @Override
        public void updateBook ( int id, Book book) throws DaoException {
            try {
                PreparedStatement ps = connection.prepareStatement(
                        "update Book set isbn = ?,title=?,author=?,price=? where id=?");
                ps.setString(1, book.getIsbn());
                ps.setString(2, book.getTitle());
                ps.setString(3, book.getAuthor());
                ps.setDouble(4, book.getPrice());
                ps.setInt(5, id);
                int res = ps.executeUpdate();
                if (res == 0) {
                    log.error("book not found");
                } else {
                    log.info("book updated successfully");
                }
            } catch (SQLException e) {
                throw new DaoException("Some dao exception",e);
            }
        }

        @Override
        public Book addBook (Book book) throws DaoException {
            try{
                PreparedStatement ps = connection.prepareStatement(
                        "insert into Book(id,isbn,title,author,price)values(?,?,?,?,?)");
                ps.setInt(1, book.getId());
                ps.setString(2, book.getIsbn());
                ps.setString(3, book.getTitle());
                ps.setString(4, book.getAuthor());
                ps.setDouble(5, book.getPrice());
                int res = ps.executeUpdate();

            } catch (SQLException e) {
                throw new DaoException("Some dao exception",e);
            }
            return book;
        }
    }

