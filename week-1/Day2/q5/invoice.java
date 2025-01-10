package q5;

public class invoice implements Payable{
 private String partName;
 private String partDescription;
 private int quantity;
 private double pricePerItem;
 public invoice(String partName, String partDescription,int quantity, double pricePerItem){
  this.partDescription = partDescription;
  this.partName = partName;
  this.pricePerItem = pricePerItem;
 }
@Override
public double getPayment() {
 System.out.println("the part name is: "+ partName);
 System.out.println("the part description is: "+partDescription);
 System.out.println("the price per item is: "+ pricePerItem);
 System.out.println("the amount is: "+ quantity*pricePerItem);
 return quantity*pricePerItem;
}
}
