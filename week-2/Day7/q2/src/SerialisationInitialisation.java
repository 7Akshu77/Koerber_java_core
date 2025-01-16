import java.io.Serializable;

class SerialisationInitialiser implements Serializable {
    private static final long serialVersionUID = 1L;//this is used to make sure tht after
    // serialisation the code remains the same and does not change if changes then throws exception
private static SerialisationInitialiser instance = new SerialisationInitialiser();
private SerialisationInitialiser(){}
public static SerialisationInitialiser getInstance() {
    return instance;
}
// makes sure that after the deserialisation there is an insatnce being created and this below code
    //makes sure that the instance creted is same as the instance created in the main method
protected Object readResolve(){
    return instance;
    }
}

public class SerialisationInitialisation {
    public static void main(String[] args) {
        SerialisationInitialiser instance = SerialisationInitialiser.getInstance();
    }
}
