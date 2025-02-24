package com.Barath.BusReservation;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;
public class Booking {
    String passengerName;
    int busNo;
    Date date;
    Booking() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of passenger : ");
        this.passengerName = sc.next();
        System.out.println("Enter bus no : ");
        busNo = sc.nextInt();
        System.out.println("Enter date dd-mm-yyyy");
        String dateInput = sc.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            date = dateFormat.parse(dateInput);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public boolean isAvailable() throws Exception {
        BusDAO busDAO = new BusDAO();
        BookingDAO bookingDAO = new BookingDAO();
        int capacity = busDAO.getCapacity(busNo);
        int booked = bookingDAO.getBookedCount(busNo,date);
        return booked < capacity;
    }
}
