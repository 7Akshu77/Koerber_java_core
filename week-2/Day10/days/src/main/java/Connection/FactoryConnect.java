package Connection;
import java.sql.DriverManager;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class FactoryConnect {
    private static Connection connection = null;
    public static Connection getConnection() {
    InputStream is = FactoryConnect.class.getClassLoader().getResourceAsStream("dbconn.properties");
    Properties pro = new Properties();
    try {
        pro.load(is);
    } catch (Exception e) {
        e.printStackTrace();
    }
    String driverName = pro.getProperty("jdbc.driverName");
    String url = pro.getProperty("jdbc.url");
    String username = pro.getProperty("jdbc.username");
    String password = pro.getProperty("jdbc.password");
   try{
       Class.forName(driverName);
       System.out.println("driver load successfully");
   }
   catch (ClassNotFoundException e){
e.printStackTrace();
   }
        try{
       connection = DriverManager.getConnection(url,username,password);
   } catch (SQLException e) {
       throw new RuntimeException(e);
   }
    return connection;

}

}
