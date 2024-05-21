package implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connectiondb {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/constructionxpert";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";


    // Method to establish a database connection
    public static Connection getConnection() throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);}
        catch (ClassNotFoundException | SQLException e){
            throw new SQLException("failed to get JDBC driver"+ e.getMessage());
        }
    }



}