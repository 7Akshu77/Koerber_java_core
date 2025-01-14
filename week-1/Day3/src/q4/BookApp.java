
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.LinkedList;

class Book {
 private int id;
 private String isbn;
 private String title;
 private String author;
 private int price;
 private int numCopies = 10;

 public Book(int id, String isbn, String title, String author, int price) {
  this.id = id;
  this.isbn = isbn;
  this.title = title;
  this.author = author;
  this.price = price;
 }

 // Getter methods
 public String getISBN() {
  return this.isbn;
 }

 public int getNumCopies() {
  return this.numCopies;
 }

 public String getTitle() {
  return this.title;
 }

 // Setter method for number of copies
 public void setNumCopies(int num) {
  this.numCopies -= num;
 }

 // Method to increment copies
 public void purchaseNumCopies(int num) {
  this.numCopies += num;
 }
}

public class BookApp {
 private LinkedList<Book> books = new LinkedList<>();

 public static void main(String[] args) {
  BookApp app = new BookApp();
  app.loadBooksFromFile("book.txt");

  try {
   app.sellBook("A233", 3);
   app.purchaseBook("A234", 12);
   Book foundBook = app.searchBook("A234");
   System.out.println("Found Book: " + foundBook.getTitle());
  } catch (BookAvailable | BookCountExceeded e) {
   System.out.println(e.getMessage());
  }
 }

 // Load books from file
 public void loadBooksFromFile(String filePath) {
  File fd = new File(filePath);
  try (FileReader fr = new FileReader(fd); 
  BufferedReader br = new BufferedReader(fr)) {
   String line;
   while ((line = br.readLine()) != null) {
    String[] details = line.split(":");
    int id = Integer.parseInt(details[0]);
    String isbn = details[1];
    String title = details[2];
    String author = details[3];
    int price = Integer.parseInt(details[4]);
    books.add(new Book(id, isbn, title, author, price));
   }
  } catch (IOException e) {
   System.out.println("The file was not found.");
  }
 }

 // Search for a book by ISBN
 public Book searchBook(String isbn) throws BookAvailable {
  for (Book bk : books) {
   if (bk.getISBN().equals(isbn)) {
    return bk;
   }
  }
  throw new BookAvailable("Book not found");
 }

 // Sell a book by ISBN
 public void sellBook(String isbn, int copies) throws BookCountExceeded, BookAvailable {
  for (Book bk : books) {
   if (bk.getISBN().equals(isbn)) {
    if (bk.getNumCopies() >= copies) {
     bk.setNumCopies(copies);
     System.out.println(copies + " copies of the book " + bk.getTitle() + " are sold.");
     return;
    } else {
     throw new BookCountExceeded("The available copies are less than requested.");
    }
   }
  }
  throw new BookAvailable("Book not found");
 }

 // Purchase more copies of a book
 public void purchaseBook(String isbn, int copies) {
  for (Book bk : books) {
   if (bk.getISBN().equals(isbn)) {
    bk.purchaseNumCopies(copies);
    System.out.println("Purchased " + copies + " copies of " + bk.getTitle());
    return;
   }
  }
  System.out.println("Book not found.");
 }
}