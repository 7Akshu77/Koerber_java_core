public class Book {
 private int id;
 private String isbn;
 private String title;
 private String author;
 private int price;
 private int numCopies =10;

 public Book(int id, String isbn, String title, String author, int price) {
  this.id = id;
  this.isbn = isbn;
  this.title = title;
  this.author = author;
  this.price = price;

 }
 public String getISBN(){
  return this.isbn;
 }
 public  int getNumCopies(){
  return this.numCopies;
 }
 public String getTitle(){
  return this.title;
 }
 public void setNumCopies(int num){
  this.numCopies = this.numCopies-num;
 }
 public void purchaseNumCopies(int num){
  this.numCopies = this.numCopies + num;
 }
}
