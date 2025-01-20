package com.java11_17.features;

//DTO: lombok small framewrok to autogen getter...

//class Person{
//    private String name;
//    private String email;
//    private double salary;
//
//    public Person(String name, String email, double salary) {
//        this.name = name;
//        this.email = email;
//        this.salary = salary;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(double salary) {
//        this.salary = salary;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Person person = (Person) o;
//        return Double.compare(person.salary, salary) == 0 && name.equals(person.name) && email.equals(person.email);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, email, salary);
//    }
//}
//1. immutable without boilerplate code
//2. aka final class  can not be absttract
//3. can imp new interface

import java.util.ArrayList;
import java.util.List;

interface Employable{
    public double getNetSalary();
}


public class E_Records {
    public record emp(String name , String email , double salary) implements Employable{

        @Override
        public double getNetSalary() {
            return salary - (salary * 0.1);
        }
    }
    public static void main(String[] args) {
      List<emp> l1 = new ArrayList<>();
        l1.add(new emp("aman","aman@gmail.com",50000));
        l1.add(new emp("bman","bman@gmail.com",55000));
        l1.add(new emp("cman","cman@gmail.com",60000));

        for(emp e: l1){
            System.out.println( e.getNetSalary());
        }



    }
}
















