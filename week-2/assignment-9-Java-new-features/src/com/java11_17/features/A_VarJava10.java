package com.java11_17.features;
class A{
    int amount;
    String name;

    public A(int amount, String name) {
        this.amount = amount;
        this.name = name;
    }
    void increaseAmount(int limit){
        var fin = amount;
        while(limit>0){
            fin+=amount;
        }
    }
}
public class A_VarJava10 {
    public static void main(String[] args) {
        for(var i=0;i<10;i++){
            System.out.println("this uses var as keyword");
        }
        A a = new A(100,"sam");
        a.increaseAmount(5);

    }
}
