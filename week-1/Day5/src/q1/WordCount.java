package q1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;


public class WordCount {
    public static void main(String [] args) throws IOException {
        Map<String , Integer> mp = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Koerber_java_core\\week-1\\Day5\\src\\q1\\story.txt")));
        String line;
        while((line= br.readLine())!=null){
            String [] tokens = line.split(" ");
            for(String word: tokens){
                mp.put(word.toLowerCase(), mp.getOrDefault(word,0)+1);
            }
        }
        for(var entry: mp.entrySet()){
            System.out.print(entry.getKey()+" appears " +entry.getValue()+" times. ");
        }
    }

}
