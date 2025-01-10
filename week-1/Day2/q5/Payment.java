package q5;

public class Payment {
 public void processPayment(Payable payable) {
  System.out.println("Processing payment");
  double amount = payable.getPayment();
  System.out.println("Payment processed: " + amount);
 }
}
