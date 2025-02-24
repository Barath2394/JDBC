package com.Barath.BusReservation;
import java.text.ParseException;
import java.util.*;
public class BusDemo {
    public static void main(String[] args) throws Exception {
        BusDAO busDAO = new BusDAO();
        try {
            busDAO.displayBusInfo();
            int userOpt = 1;
            Scanner sc = new Scanner(System.in);

            while (userOpt == 1) {
                System.out.println("Enter 1 to Book and 2 to exit");
                userOpt = sc.nextInt();
                if (userOpt == 1) {
                    Booking booking = new Booking();
                    if (booking.isAvailable()) {
                        BookingDAO bookingDAO = new BookingDAO();
                        bookingDAO.addBooking(booking);
                        System.out.println("Your booking is confirmed");
                    }
                    else {
                        System.out.println("Sorry. Bus is full. Try another bus or date");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
