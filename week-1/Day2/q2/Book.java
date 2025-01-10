package q2;
/*1) Create the following Book class.

Book
String bookTitle String
author String ISBN
int numOfCopies

Book(String, String, String, int)
void display()

Here is what you need to do.
1) Create the following Book class.
2) display() method will display the book info in “Title – Author – ISBN – Quantity” format.
2) Create another class “BookStore” which should contain all the book objects. For now use an
array of Book type and assume you can have maximum 10 different books but each could have
multiple copies.*/

import java.util.Scanner;

public class Book {
private String bookTitle;
private    String author;
private    String ISBN;
private    int numOfCopies;

    public Book(String bookTitle ,String author ,String ISBN,int numOfCopies){
    this.bookTitle = bookTitle;
    this.author = author;
    this.ISBN = ISBN;
    this.numOfCopies = numOfCopies;
    }
    public void display(){
        System.out.println(this.bookTitle+"-"+this.author+"-"+this.ISBN+"-"+this.numOfCopies);
    }
    public String getBookTitle(){
        return this.bookTitle;
    }
    public boolean checkQuantity(int count){
        if(count<numOfCopies){
            return true;
        }
        else{

            return false;
        }
    }
    public String getISBN(){
        return this.ISBN;
    }
    public int getNumOfCopies(){
        return this.numOfCopies;
    }
    public void updateCopies(int num){
        numOfCopies+=num;
    }
    public void updateQuantity(int quantity){
        this.numOfCopies-=quantity;
    }


}
class BookStore{
    private Book []books;
    public int bookCount;
    public BookStore(){
        books = new Book[10];
        bookCount=0;
    }
    public void addBook(){
        if(bookCount>10){
            System.out.println("Max books exceeded. Try again after removing one book");
        }
        else{
            Scanner sc = new Scanner(System.in);
            String title;
            String ISBN;
            String author;
            int copies;
            System.out.println("Enter the book name:");
            title = sc.nextLine();
            System.out.println("Enter the author name:");
            author = sc.nextLine();
            System.out.println("Enter the ISBN number:");
            ISBN = sc.nextLine();
            System.out.println("Enter the cpoies:");
            copies = sc.nextInt();
            Book b1 = new Book(title,author,ISBN,copies);
            books[bookCount] = b1;
            bookCount++;
        }
    }
    public void sell(String title, int quantity){
        for(int i=0;i<bookCount;i++){
            if(books[i].getBookTitle().equalsIgnoreCase(title)){
                if(books[i].checkQuantity(quantity)){
                    System.out.println("The book "+ title+" is sold in "+ quantity+" copies");
                    books[i].updateCopies(quantity);

                }
                else{
                    System.out.println( "Invalid option");
                }

            }
        }
    }
    public void order(String isbn, int numCopies){
    for(int i=0;i<bookCount;i++){
        if(books[i].getISBN().equalsIgnoreCase(isbn)){
            System.out.println("the order is placed successfully");
            books[i].updateCopies(numCopies);
            return;
        }


    }
        Scanner sc  =new Scanner(System.in);
        System.out.println("Enter the title of the new book");
        String newTitle = sc.next();
    }
}
