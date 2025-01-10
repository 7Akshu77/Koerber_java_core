
import java.util.ArrayList;
import java.util.Scanner;

abstract  class Employee {
 private String name;
 private int id;

 public Employee(String name, int id) {
  this.id = id;
  this.name = name;
 }

 abstract public double weeklySalary();

 abstract public void incSalary(int percent);

}

class SalariedEmployee extends Employee {
 private double salary = 20000;

 public SalariedEmployee(String name, int id, double salary) {
  super(name, id);
  this.salary = salary;
 }

 public void incSalary(int percent) {
  this.salary = salary * (percent / 100.0) + salary;
  System.out.println("The increased salary is:" + this.salary);
 }

 public double weeklySalary() {
  //System.out.println("the weekly salary is: " + salary);
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

 public void incSalary(int percent) {
  this.salaryPerHour = salaryPerHour * (percent / 100.0) + salaryPerHour;
  System.out.println("The increased salary is:" + this.salaryPerHour);
 }

 public double weeklySalary() {
  //System.out.println("the weekly salary is: " + salaryPerHour * hours);
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

 public void incSalary(int percent) {
  System.out
    .println("the increased salary is: " + (percent / 100.0) * sales * commisionPercent + sales * commisionPercent);
 }

 public double weeklySalary() {
  //System.out.println("the weekly salary for commission employee is:" + sales * commisionPercent/100.0);
  return sales * commisionPercent/100.0;
 }
}
class Payment{
  public void weeklySalary(Employee emp){
System.out.println("the salary is "+ emp.weeklySalary());
  }
  public void incSalary(Employee emp){
    System.out.println("enter the percentage of salary to be increased: ");
    Scanner sc  = new Scanner(System.in);
    int percent  = sc.nextInt();
    emp.incSalary(percent);
  }
}
public class q4tester{
 public static void main(String [] args){
  ArrayList<Employee> emp= new ArrayList<Employee>();
 emp.add(new SalariedEmployee("kzsjd", 62, 100000));
 emp.add(new HourlyEmployee("zsmxjfnls",75,5));
 emp.add(new CommissionEmployee("kjawehdknwahd", 8478293, 1000, 10));
 Payment pay = new Payment();
 pay.weeklySalary(emp.get(0));
 pay.weeklySalary(emp.get(1));
pay.incSalary(emp.get(0));
 }
}
