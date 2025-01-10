package q5;

public class CommissionEmployee extends Employee {
 int sales;
 double commisionPercent;

 public CommissionEmployee(String name, int id, int sales, double commisionPercent) {
  super(name, id);
  this.sales = sales;
  this.commisionPercent = commisionPercent;
 }

 public double getPayment() {
  System.out.println("the weekly salary for commission employee is:" + sales * commisionPercent / 100.0);
  return sales * commisionPercent / 100.0;
 }
}
