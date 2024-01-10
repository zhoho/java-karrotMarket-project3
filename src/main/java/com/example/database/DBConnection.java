package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection conn = null;

    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection("jdbc:sqlite:karrotMarket.db");
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static void closeConnection(){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}