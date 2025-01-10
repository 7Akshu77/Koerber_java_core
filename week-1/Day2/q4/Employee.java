package q4;

abstract public class Employee {
    private String name;
    private int id;
    public Employee(String name, int id){
        this.id = id;
        this.name  = name;
    }
   abstract public void weeklySalary();
   abstract public void incSalary(int percent);

}
