package com.Barath.BusReservation;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class BookingDAO {
    public int getBookedCount(int busNo, Date date) throws Exception{
        String query = "SELECT count(passenger_name) from booking WHERE bus_no = ? and travel_date = ?";
        Connection connection = DbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        preparedStatement.setInt(1,busNo);
        preparedStatement.setDate(2,sqlDate);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }
    public void addBooking(Booking booking) throws Exception {
        String query = "Insert into booking values(?,?,?)";
        Connection con = DbConnection.getConnection();
        java.sql.Date sqldate = new java.sql.Date(booking.date.getTime());
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, booking.passengerName);
        pst.setInt(2, booking.busNo);
        pst.setDate(3, sqldate);
        pst.executeUpdate();
    }
}
