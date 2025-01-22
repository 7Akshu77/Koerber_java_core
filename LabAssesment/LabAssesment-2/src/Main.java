import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map=new HashMap<String, Integer>();
        map.put("raj", 95);
        map.put("ekta", 75);
        map.put("rajiv", 85);
        map.put("sunita", 66);
        map.put("gunika", 99);
        System.out.println("------printing map------");
        map.entrySet().forEach(System.out::println);
        System.out.println("------printing only keys------");
        map.entrySet().stream().filter(m->m.getKey().contains("raj")).forEach(System.out::println);
        System.out.println("-------------map sorted by key--------------");
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
        System.out.println("-------------map sorted by value--------------");
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
        System.out.println("-------------map reverse sorted by key--------------");
        map.entrySet().stream()
                .sorted((entry1,entry2) -> entry2.getKey().compareTo(entry1.getKey()))
                .forEach(System.out::println);
    }
}
