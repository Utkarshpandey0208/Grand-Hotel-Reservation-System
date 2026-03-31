package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class dbConnection{
  private static Connection conn = null;

  private dbConnection(){};

  public static Connection getConnection() {
    if(conn != null){
      return conn;
    }

    try {
        Properties props = new Properties();
        FileInputStream fs = new FileInputStream("D:\\Programming\\Java\\Learning\\JDBC\\Hotel_reservation_system\\config\\config.properties");
        props.load(fs);

        String url = props.getProperty("db.url");
        String username = props.getProperty("db.username");
        String password = props.getProperty("db.password");
        String driver = props.getProperty("db.driver");

        Class.forName(driver);
        conn = DriverManager.getConnection(url,username,password);

        System.out.println("Database Connected Successfully !!");
    } catch (IOException e) {
            System.out.println("Could not read config.properties: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
        return conn;
  }
  public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}
