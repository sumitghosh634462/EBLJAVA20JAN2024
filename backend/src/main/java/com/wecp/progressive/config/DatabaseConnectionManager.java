package com.wecp.progressive.config;
<<<<<<< HEAD

public class DatabaseConnectionManager {

}
=======
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public class DatabaseConnectionManager{
    private static final Properties properties = new Properties();

    static{
        loadProperties();
    }

    private static void loadProperties(){
        try(InputStream input = DatabaseConnectionManager.class.getClassLoader().getResourceAsStream("application.properties")){
            if(input == null){
                throw new IllegalStateException("resource.properties not found in classpath");
            }
            properties.load(input);
        }catch(IOException e){
            throw new RuntimeException("Error loading properties file",e);
        }
    }

    public static Connection getConnection() throws SQLException{
        String url = properties.getProperty("spring.datasource.url");
        String user = properties.getProperty("spring.datasource.username");
        String password = properties.getProperty("spring.datasource.password");
        return DriverManager.getConnection(url,user,password);
    }
}





// public class DatabaseConnectionManager {
// public static final String JDBC_URL =  "jdbc:mysql://127.0.0.1:3306/banksafe_wecp";
// public static final String USERNAME = "root";
// public static final String PASSWORD = "root";

// public static Connection getConnection() throws SQLException{

//     return DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
// }
// }
>>>>>>> 7a35078e25d407a92afa99fb156b1faea3380993
