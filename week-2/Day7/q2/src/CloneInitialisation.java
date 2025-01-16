class  CloneInitialiser implements Cloneable{
    private static final CloneInitialiser instance = new CloneInitialiser();
    private CloneInitialiser(){}
    public static CloneInitialiser getInstance() {
        return instance;
    }

    protected Object clone () throws CloneNotSupportedException{
        throw new CloneNotSupportedException("Singleton cloning is not allowed");
    }

}

public class CloneInitialisation {
    public static void main(String[] args) {
        CloneInitialiser instance = CloneInitialiser.getInstance();
    }
}
