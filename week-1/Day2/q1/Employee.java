
class Employee{
 private int id;
 private String firstName;
 private String lastName;
 private int salary;

 public Employee(int id, String firstName , String lastName , int salary){
  this.id= id;
  this.firstName = firstName;
  this.lastName = lastName;
  this.salary = salary;
 }
 public int getID(){
System.out.println("id is: "+id);
return id;
 }
 
 public String getfirstName() {
  System.out.println("firstName is: " + firstName);
  return firstName;
 }
 
 public String getlastName() {
  System.out.println("lastName is: " + lastName);
  return lastName;
 }
 
 public String getName() {
  System.out.println("Name is: " + firstName+lastName);
  return (firstName+lastName);
 }
 
 public int getSalary() {
  System.out.println("salary is: " + salary);
  return salary;
 }
public void setSalary(int salary){
 this.salary = salary;
}
public int getAnnualSalary(){
return salary*12;
}
public int raiseSalary(int percent){
int increase = salary*(percent/100);
int ans = increase+salary;
return ans; 
}
@Override
public String toString(){
return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
  + "]";
}
}
public class q1 {
 public static void main(String[] args){
  Employee emp1 = new Employee(101, "ram", "sam", 1000000);
  emp1.raiseSalary(10);
  System.out.println(emp1);
 }
}
