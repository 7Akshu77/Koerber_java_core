package q3;
import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MaxNumber {
    public static void main(String[] args) throws IOException {
        List<Double> nums = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Koerber_java_core\\week-1\\Day5\\src\\q3\\data.txt")))) {
            String line;
            while ((line = br.readLine()) != null) {
                nums.add(Double.parseDouble(line));
            }
        }
        nums.sort(new Maxi());
        System.out.println(nums.getFirst());
    }
}
