package com.java9.features;
//private method inside an interface
//interface Foof{
//}
 interface Java8DBLogging
{
    default void logInfo(String message)
    {
        System.out.println(message);
        helper();
    }

    default void logWarn(String message)
    {
        System.out.println(message);
        helper();
}

    default void logError(String message)
    {
        System.out.println(message);
      helper();
    }
    private void helper(){
        System.out.println(" Step1: Connect to DataBase");
        System.out.println(" Setp2: Log Info Message");
        System.out.println("Setp3: Close the DataBase connection");
    }

}
class Java8DBLoggingImpl implements Java8DBLogging{}

public class A_PrivateMethodInsideInterface {
    public static void main(String[] args) {
Java8DBLoggingImpl jdb = new Java8DBLoggingImpl();
jdb.logError("this is error message");
jdb.logInfo("this is info message");
jdb.logWarn("this is warning message");


    }
}
















