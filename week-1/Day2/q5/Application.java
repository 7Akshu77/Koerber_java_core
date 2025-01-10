package q5;

public class Application {
 public static void main(String[] args) {
  ArrayList<Employee> emp = new ArrayList<Employee>();
  emp.add(new SalariedEmployee("kzsjd", 62, 100000));
  emp.add(new HourlyEmployee("zsmxjfnls", 75, 5));
  emp.add(new CommissionEmployee("kjawehdknwahd", 8478293, 1000, 10));
  Payment paymentProcessor = new Payment();

  // Process employee payments
  for (Employee e : emp) {
   paymentProcessor.processPayment(e);
  }

  // Process an invoice
  Invoice invoice = new Invoice("skjedhfkje", "kjhduew", 1000, 500);
  paymentProcessor.processPayment(invoice);
 }
}
