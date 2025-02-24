package com.Barath.BusReservation;

import java.sql.*;
public class DbConnection {
    private static final String url = "jdbc:mysql://localhost:3306/busresv";
    private static final String userName = "root";
    private static final String passWord = "barath23904";
    public static Connection getConnection() throws Exception {
        try {
            return DriverManager.getConnection(url, userName, passWord);
        } catch (SQLException e) {
            throw new Exception("Error establishing database connection: " + e.getMessage(), e);
        }
    }

}
