package q2;

import java.util.Scanner;

public class bookStoreApp {
    public static void main(String [] Args) {

//        Book b1 = new Book("striker", "ana huang", "12753SH", 10);
//        BookStore b = new BookStore();
//        b.addBook(b1);
//
//        Book b2 = new Book("king of wrath", "ana huang", "12353SH", 12);
//        Book b3 = new Book("king of pride", "ana huang", "22753SH", 1);
//        Book b4 = new Book("king of greed", "ana huang", "12753SK", 2);
//        Book b5 = new Book("king of sloth", "ana huang", "12953SH", 5);
//        b.addBook(b2);
//        b.addBook(b3);
//        b.addBook(b4);
//        b.addBook(b5);
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number of books to be loaded:");
        n  = sc.nextInt();
        BookStore b = new BookStore();
        while(n>0){
            b.addBook();
            n--;
        }
        System.out.println(b.bookCount);
        b.sell("striker", 5);
        b.order("22753SH", 10);
        b.order("9378926", 5);

    }
}
