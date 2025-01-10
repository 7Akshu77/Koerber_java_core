package q4;

public class SalariedEmployee extends Employee{
    private double salary = 20000;
    public SalariedEmployee(String name, int id, double salary){
        super(name, id);
        this.salary = salary;
    }
    public void incSalary(int percent) {
        this.salary = salary*(percent/100.0)+salary;
        System.out.println("The increased salary is:"+ this.salary);
    }
    public void weeklySalary(){
        System.out.println("the weekly salary is: "+ salary);
    }
}
