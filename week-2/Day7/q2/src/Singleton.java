class DatabaseConnection {
    private static DatabaseConnection instance = new DatabaseConnection();
    private DatabaseConnection(){}
    public static DatabaseConnection getInstance() {

                if(instance==null){
                    instance = new DatabaseConnection();

        }
        return instance;
    }
    public void connect(){
        System.out.println("Connection established successfully");
    }
}

public class Singleton {
    public static void main(String[] args) {
        DatabaseConnection connector1 = DatabaseConnection.getInstance();
        connector1.connect();
        DatabaseConnection connector2 = DatabaseConnection.getInstance();
        connector2.connect();
    }



}