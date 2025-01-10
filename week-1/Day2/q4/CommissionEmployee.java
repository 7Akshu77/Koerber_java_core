public class CommissionEmployee extends Employee{
 int sales;
 double commisionPercent;
 public CommissionEmployee(String name , int id ,int sales, double commisionPercent){
super(name,id);
this.sales = sales;
this.commisionPercent = commisionPercent;
 }
 public void incSalary(int percent){
  System.out.println("the increased salary is: "+ (percent/100.0)*sales*commisionPercent+sales*commisionPercent);
 }
 public void weeklySalary(){
  System.out.println("the weekly salary for commission employee is:"+ sales*(commisionPercent/100.0));
 }
}