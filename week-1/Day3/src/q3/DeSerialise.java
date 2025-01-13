package q3;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerialise {
    public static void main(String[] args){
        try(FileInputStream fis = new FileInputStream("Employee.ser");
            ObjectInputStream oos = new ObjectInputStream(fis)){
            Employee emp = (Employee) oos.readObject();
            System.out.println("the deseralised info is " + emp);
        }
        catch(IOException | ClassNotFoundException e ){
            e.printStackTrace();
        }
    }
}
