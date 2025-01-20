package com.java9.features;
import com.pojo.Book;

import java.sql.Array;
import  java.util.*;
class A{
        void foo(){
            System.out.println("foo of class A");
        }
}
class B extends  A{
    void foo(){
        System.out.println("foo of class B override");
    }
}
public class C_DiamondOp {
    public static void main(String[] args) {
    List<String> l1 = new ArrayList<String>();
    List<Book> l2 = new LinkedList<>();
    l2.add(new Book(1,"aman","java",500,470));
        l2.add(new Book(2,"bman","javascript",600,470));
        l2.add(new Book(3,"cman","C++",800,470));
        l2.forEach(System.out::println);

    }
}
