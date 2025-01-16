class EagerInitialiser{
    private static EagerInitialiser instance = new EagerInitialiser();
    private  EagerInitialiser(){}

    public static EagerInitialiser getInstance() {
        return instance;
    }
    public void print(){
        System.out.println("singleton Eager initialisation implemented");
    }
}
public class EagerInitialisation {

    public static void main(String[] args) {
EagerInitialiser instance = EagerInitialiser.getInstance();
instance.print();

    }
}