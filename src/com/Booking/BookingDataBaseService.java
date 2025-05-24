package com.Booking;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.App;
import com.DataBaseConnection;

public class BookingDataBaseService {

    public static void addBooking() {
        System.out.println("Enter User ID");
        int userID = App.scan.nextInt();
        App.scan.nextLine();

        System.out.println("Enter Bus ID");
        int busID = App.scan.nextInt();
        App.scan.nextLine();

        System.out.println("Enter SeatNumber");
        int seatNO = App.scan.nextInt();
        App.scan.nextLine();

        System.out.println("Enter Seat Type");
        String type = App.scan.nextLine();

        System.out.println("Enter Cost");
        double cost = App.scan.nextDouble();
        App.scan.nextLine();

        String query = "insert into Booking (userID,busID,seatNumber,seatType,cost)values(?,?,?,?,?)";

        try (Connection connection = DataBaseConnection.getConnection();
                PreparedStatement p = connection.prepareStatement(query)) {

            p.setInt(1, userID);
            p.setInt(2, busID);
            p.setInt(3, seatNO);
            p.setString(4, type);
            p.setDouble(5, cost);

            int row = p.executeUpdate();
            System.out.println("User added successfully. Rows affected: " + row);
            connection.close();
            p.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void viewBokkings()
    {
        String query="SELECT user.id, user.name, user.contact, user.email, " +
                   "Bus.busID, Bus.busName, Bus.busCapacity, Bus.busAvailableSeats, " +
                   "Route.routeID, Route.startPoint, Route.startTime, Route.endPoint, " +
                   "Route.endTime, Route.distance, Route.date, " +
                   "Booking.seatNumber, Booking.seatType, Booking.cost " +
                   "FROM Booking " +
                   "INNER JOIN user ON Booking.userID = user.id " +
                   "INNER JOIN Bus ON Booking.busID = Bus.busID " +
                   "INNER JOIN Route ON Bus.routeID = Route.routeID";

        try {
            Connection connection=DataBaseConnection.getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(query);
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
