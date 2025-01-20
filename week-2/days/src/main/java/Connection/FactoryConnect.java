package Connection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class FactoryConnect {
    public static Connection getConnection() {
    InputStream is = FactoryConnect.class.getClassLoader().getResourceAsStream("dbconn.properties");
    Properties pro = new Properties();
    try {
        pro.load(is);
    } catch (Exception e) {
        e.printStackTrace();
    }
    String driver = pro.getProperty("jdbc.driverName");
    String url = pro.getProperty("jdbc.url");
    String username = pro.getProperty("jdbc.username");
    String password = pro.getProperty("jdbc.password");
   try{
       Class.forName(driver);
   }
   catch (ClassNotFoundException e){

   }
        Connection connection = null;
        try{
       connection = java.sql.DriverManager.getConnection(url,username,password);
   } catch (SQLException e) {
       throw new RuntimeException(e);
   }
    return connection;

}

}
