import java.util.HashMap;
import java.util.Map;

public class MainStudent {
    public static void main(String[] args) {
        Map<Student, Integer> map=new HashMap<>();
        map.put(new Student(109, "raj", 95), 95);
        map.put(new Student(61, "keta", 78), 78);
        map.put(new Student(11, "gunika", 98), 98);
        map.put(new Student(19, "keshav", 97), 97);

        map.entrySet().stream()
                .sorted((e1, e2) -> e1.getKey().getName().compareTo(e2.getKey().getName()))
                .forEach(entry ->
                        System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue())
                );
        map.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e1.getKey().getId(), e2.getKey().getId()))
                .forEach(entry ->
                        System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue())
                );
    }
}
