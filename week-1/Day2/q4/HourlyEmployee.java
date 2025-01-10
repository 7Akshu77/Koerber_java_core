package q4;

public class HourlyEmployee extends Employee {
 private double salaryPerHour=1000;
private int hours;
 public HourlyEmployee(String name, int id,int hours){
        super(name, id);
        this.hours  = hours;
    }

 public void incSalary(int percent) {
  this.salaryPerHour = salaryPerHour * (percent / 100.0) + salaryPerHour;
  System.out.println("The increased salary is:" + this.salaryPerHour);
 }

 public void weeklySalary() {
  System.out.println("the weekly salary is: " + salaryPerHour*hours);
 }
}
