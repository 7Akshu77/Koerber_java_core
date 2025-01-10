package q5;

public class HourlyEmployeed extends Employee{
 private double salaryPerHour = 1000;
 private int hours;

 public HourlyEmployee(String name, int id, int hours) {
  super(name, id);
  this.hours = hours;
 }

 public double getPayment() {
  System.out.println("the weekly salary is: " + salaryPerHour * hours);
  return salaryPerHour * hours;
 }
}
