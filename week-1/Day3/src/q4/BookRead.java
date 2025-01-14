import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.LinkedList;
class Book{
  private int id;
    private String isbn;
    private String title;
    private String author;
    private int price;
    private int numCopies; 

    public Book(int id, String isbn, String title, String author, int price, int numCopies) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
        this.numCopies = numCopies;
    }

    

    } 
    public  int getNumCopies(){
     return this.numCopies;

    public String getTitle(){  re
    turn this.title;
 }
 public void setNumCopies(int num){
  this.numCopies = this.numCopies-num;
 }
 public void purchaseNumCopies(int num){
  this.numCopies = this.numCopies + num;
 }
}
public class BookRead{
 
 public BookRead(String Filename){
 File fd = new File(Filename);
 FileReader fr = new FileReader(fd);

 private LinkedList<Book> books = new LinkedList<>();

try(BufferedReader br = new BufferedReader(fr)){
 String line = null;
 while((line =br.readLine())!=null){
  String [] details = line.split(":");
  int id = Integer.parseInt(details[0]);
  String isbn = details[1];
  String title = details[2];
  String author = details[3];
  int price = Integer.parseInt(details[4]);
  int copies = 10;
  books.add(new Book(id,isbn,title,author,price,copies));
 }
 catch(IOException e){
  System.out.println("the file is not found");
 }
}
 }
}