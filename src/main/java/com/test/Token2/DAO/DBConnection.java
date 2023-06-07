package com.test.Token2.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String url = "jdbc:h2:mem:testdb";
    private static final String username = "sa";
    private static Connection con;
    private static final String password = "pass";

    public static Connection getConnection() {

        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            System.out.println("Failed to create the database connection.");
        }
        return con;

    }
}
