 class ReflectionInitialiser {
    private static ReflectionInitialiser instance = new ReflectionInitialiser();
    private ReflectionInitialiser() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }
    public static ReflectionInitialiser getInstance() {
        if(instance == null) {
            instance = new ReflectionInitialiser();
        }
        return instance;
    }
    public void print() {
        System.out.println("Reflection initialisation implemented");
    }
}
public class ReflectionInitialisation {
    public static void main(String[] args) {
        ReflectionInitialiser instance = ReflectionInitialiser.getInstance();
        instance.print();
    }
}
