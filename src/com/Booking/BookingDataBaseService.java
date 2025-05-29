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

    public static void viewBokkings() {
        String query = "SELECT user.id, user.name, user.ph, user.email, " +
                "Bus.busID, Bus.busName, Bus.busCapacity, Bus.busAvailableSeats, " +
                "Route.routeID, Route.startPoint, Route.startTime, Route.endPoint, " +
                "Route.endTime, Route.distance, Route.date, " +
                "Booking.seatNumber, Booking.seatType, Booking.cost " +
                "FROM Booking " +
                "INNER JOIN user ON Booking.userID = user.id " +
                "INNER JOIN Bus ON Booking.busID = Bus.busID " +
                "INNER JOIN Route ON Bus.routeID = Route.routeID";
        System.out.println("------ Booking Details ------");
        try {
            Connection connection = DataBaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                System.out.println("User ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Contact: " + rs.getLong("ph"));
                System.out.println("Email: " + rs.getString("email"));

                System.out.println("Bus ID: " + rs.getInt("busID"));
                System.out.println("Bus Name: " + rs.getString("busName"));
                System.out.println("Capacity: " + rs.getInt("busCapacity"));
                System.out.println("Available Seats: " + rs.getInt("busAvailableSeats"));

                System.out.println("Route ID: " + rs.getInt("routeID"));
                System.out.println("From: " + rs.getString("startPoint") + " at " + rs.getString("startTime"));
                System.out.println("To: " + rs.getString("endPoint") + " at " + rs.getString("endTime"));
                System.out.println("Distance: " + rs.getDouble("distance") + " km");
                System.out.println("Date: " + rs.getString("date"));

                System.out.println("Number of Seats: " + rs.getInt("seatNumber"));
                System.out.println("Seat Type: " + rs.getString("seatType"));
                System.out.println("Cost: ₹" + rs.getDouble("cost"));

                System.out.println("---------------------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
