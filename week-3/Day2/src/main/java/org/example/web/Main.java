package org.example.web;
import org.example.configapp.ConfigApp;
import org.example.service.ServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.example.persistence.Book;
import org.example.service.Service;
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigApp.class);
        Service service = (Service) ctx.getBean("bs");
       service.addBook(new Book(1,"123434","asdf","author1",23));
//        service.getAllBooks().forEach(System.out::println);
//        service.addBook(new Book(2,"123434","asdf","author2",33));
//        service.getBookById(1);
//        service.updateBook(1,new Book(1,"123434","asdf","author3",43));
//        service.getAllBooks().forEach(System.out::println);
        service.deleteBook(1);
        service.getAllBooks().forEach(System.out::println);

    }
}
