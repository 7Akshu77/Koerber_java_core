package assesment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args){
        ArrayList<MerchandiseInventory> items = new ArrayList<MerchandiseInventory>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Koerber_java_core\\week-1\\Day3\\src\\assesment\\InputData.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] token = line.split(" ");
                String itemCode = token[0];
                int quantity = Integer.parseInt(token[1]);
                double unitPrice = Double.parseDouble(token[2]);
                items.add(new MerchandiseInventory(itemCode, quantity, unitPrice));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        Collections.sort(items);
        System.out.println("The sorting based on item code is:");
       for(MerchandiseInventory it:items){
           System.out.println(it);
       }

        Collections.sort(items,new OrderByPrice());
        System.out.println("The sorting based on price is:");
        for(MerchandiseInventory it:items){
            System.out.println(it);
        }




    }

}
