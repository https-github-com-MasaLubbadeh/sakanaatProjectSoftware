package najah.edu.acceptance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseClass {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sakanat";
        String username = "root";
        String password = "";

        try {
            // Register MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Connection successful
            System.out.println("Connected to MySQL database!");

            // Perform database operations here

            // Close connection
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}
