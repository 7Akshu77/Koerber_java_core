package Repo.DaoException.DaoImpl;
import Connection.FactoryConnect;
import Repo.DaoException.Book;
import Repo.DaoException.BookDao;
import Repo.DaoException.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoImpl  implements BookDao {
    private static Connection connection = null;
    public void DaoImpl() throws ClassNotFoundException {
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

            } catch (Exception e) {
                throw new DaoException(e.getMessage());
            }

        return book;
        }

        @Override
        public void deleteBook (int id) throws DaoException {
            Book book = null;
            try {
                PreparedStatement ps = connection.prepareStatement("delete book from id =?");
                ps.setInt(1,id);
                ps.executeUpdate();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
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
                        "update book set title=?,author=?,price=? where id=?,");
                ps.setInt(1, id);
                ps.setString(2, book.getTitle());
                ps.setString(3, book.getAuthor());
                ps.setDouble(4, book.getPrice());
                int res = ps.executeUpdate();
                if (res == 0) {
                    throw new DaoException("Book not found");
                } else {
                    System.out.println("successfully updated");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public Book addBook (Book book) throws DaoException {
            try{
                PreparedStatement ps = connection.prepareStatement(
                        "insert into Book(id,title,author,price)values(?,?,?,?)");
                ps.setInt(1, book.getId());
                ps.setString(2, book.getTitle());
                ps.setString(3, book.getAuthor());
                ps.setDouble(4, book.getPrice());
                int res = ps.executeUpdate();
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
    }

