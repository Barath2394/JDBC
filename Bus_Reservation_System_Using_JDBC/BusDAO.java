package com.Barath.BusReservation;

import java.sql.*;

public class BusDAO {
    public void displayBusInfo() throws Exception {
        String query = "SELECT * FROM bus";
        Connection connection = DbConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            System.out.println("Bus No : " + resultSet.getInt(1));
            if (resultSet.getInt(2) == 0) {
                System.out.println("Ac : no");
            }
            else {
                System.out.println("AC : yes");
            }
            System.out.println("Capacity : " + resultSet.getInt(3));
        }
        System.out.println("--------------------------------------------------");
    }
    public int getCapacity(int id) throws Exception {
        String query = "SELECT capacity from bus where id = " + id;
        Connection connection = DbConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();
        return resultSet.getInt(1);
    }
}
