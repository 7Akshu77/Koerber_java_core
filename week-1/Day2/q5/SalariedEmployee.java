package q5;

public class SalariedEmployee extends Employee{
 private double salary;

 public SalariedEmployee(String name, int id, double salary) {
  super(name, id);
  this.salary = salary;
 }

 @Override
 public double getPayment() {
  System.err.println("the salary is:" + salary);
  return salary;
 }
}
