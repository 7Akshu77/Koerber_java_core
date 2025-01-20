package com.java11_17.features;

public class C_PatternMatching_instanceOfOpImprovement {
    public static void main(String[] args) {
Object data = "java";
if(data instanceof String){
    String s = (String) data;
    System.out.println(s.length());
}
if(data instanceof String s){
    System.out.println("It is true"+ s.length());
}
        Object data1="javascript is good";
        if(data1 instanceof String dataString && dataString.length()>10){// checks if the data is of type
            //string and is so then casts it as a string and stores in dataString variable.
            System.out.println(dataString);
        }else {
            System.out.println("something else");
        }

//
    }
}
