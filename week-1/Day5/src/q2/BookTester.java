package q2;

import java.util.ArrayList;
import java.util.List;

public class BookTester {
    public static void main(String[] args){
       Book book1 = new Book("Effective Java", "Joshua Bloch");
        Book book2 = new Book("Clean Code", "Robert C. Martin");
        Book book3 = new Book("Java in Depth", "John Doe");
        Book book4 = new Book("The Pragmatic Programmer", "Andrew Hunt");

        // Create a book collection
        Book[] books = {book1, book2, book3, book4};
        BookCollection collection = new BookCollection("sam", books);

        // Check if a particular book is in the collection
        Book searchBook = new Book("John Doe","Java in Depth");
        collection.hasBook(searchBook);

        // Sort using Comparable (by title)
        collection.sort();
        System.out.println("Books sorted by title:");
        System.out.println(collection);

        // Sort using Comparator (by author)
        collection.sort(new SortBasedAuthor());
        System.out.println("Books sorted by author:");
        System.out.println(collection);
    }
}
