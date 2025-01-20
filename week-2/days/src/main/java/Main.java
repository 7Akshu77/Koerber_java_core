import Repo.DaoException.Book;
import Repo.DaoException.DaoException;
import Service.ServiceImp;
import Service.Services;

import java.util.List;

public class Main {

    public static void main(String[] args) throws DaoException {
        Services ser = new ServiceImp();


        System.out.println("------------- all the books-----------");
        List<Book> books = ser.getAllBooks();
        books.forEach(System.out::println);

        System.out.println("-------------add book-----------");
        Book book = new Book(1,"jdw321","Verity","Collen Hover",300);
        ser.addBook(book);
        Book book1 = new Book(2,"jdw311","Atomic habits","James Clear",300);
        ser.addBook(book1);
        Book book2 = new Book(3,"jdw331","Power of positive thinking","H D Carroll",300);
        ser.addBook(book2);
        Book book3 = new Book(4,"jdw341","Shatter me "," Tahiri",300);
        ser.addBook(book3);
        Book book4 = new Book(5,"jdw351","Why has no one told me","Marianne Williamson",300);
        ser.addBook(book4);



        System.out.println("-------------delete book-----------");
        ser.deleteBook(5);


        System.out.println("-------------update book-----------");
        ser.updateBook(4,new Book(4,"book4","Twisted hate","Ana Huang",400));

        System.out.println("-------------get book by id-----------");
        Book book6 = ser.getBookById(4);
        System.out.println(book1);
        books = ser.getAllBooks();
        books.forEach(System.out::println);

    }
}
