package q3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialise {
    public static void main(String[] args){
        Employee emp = new Employee(1,"ram",new Address("wdhwui",4,"dhwgyu","bengaluru",560031),50000);
        try(FileOutputStream  fileOut= new FileOutputStream("Employee.ser");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut)){
            objOut.writeObject(emp);
            System.out.println("serialisation is completed");
        }
        catch (IOException e){
           e.printStackTrace();
        }
    }
}
