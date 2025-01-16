class StaticInitialiser{
    private static StaticInitialiser instance = new StaticInitialiser();
    private StaticInitialiser(){}
    static {
        try {
            instance = new StaticInitialiser();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static StaticInitialiser getInstance() {
        return instance;
    }
    public void print()
    {
        System.out.println("singleton static initialisation implemented");
    }
}
public class StaticInitialisation {
    public static void main(String[] args) {
        StaticInitialiser instance = StaticInitialiser.getInstance();
        instance.print();
    }
}
