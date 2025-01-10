
import java.util.ArrayList;

abstract class Employee implements Payable{
 private String name;
 private int id;

 public Employee(String name, int id) {
  this.id = id;
  this.name = name;
 }
abstract public double getPayment();

}

class SalariedEmployee extends Employee {
 private double salary;

 public SalariedEmployee(String name, int id, double salary) {
  super(name, id);
  this.salary = salary;
 }
@Override
public double getPayment() {
 System.err.println("the salary is:" );
 return salary;
}
}

class HourlyEmployee extends Employee {
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

class CommissionEmployee extends Employee {
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

