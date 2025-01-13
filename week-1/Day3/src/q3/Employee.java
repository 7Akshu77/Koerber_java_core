package q3;

import java.io.Serializable;

public class Employee implements Serializable {
    private int id;
    private String name;
    private double salary;
    private Address address;

    public Employee(int id, String name, Address address , double salary){
        this.id = id;
        this.salary = salary;
        this.address = address;
        this.name = name;
    }

    public void display(){
        System.out.println("the id is: "+ id);
        System.out.println("the name is: "+ name);
        System.out.println("the salary is: "+ salary);
        System.out.println("the address is: "+ address);
    }
@Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("ItemID: ").append(id).append("name: ").append(name).append("salary")
                .append(salary).append("address").append(address);
        return sb.toString();
}
}
