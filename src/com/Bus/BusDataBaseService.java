package com.Bus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.App;
import com.DataBaseConnection;

public class BusDataBaseService {

    public static void addBus() {
        System.out.println("Enter Bus Name");
        String name = App.scan.nextLine();

        System.out.println("Enter Bus Capacity");
        int capacity = App.scan.nextInt();
        App.scan.nextLine();

        System.out.println("Enter Bus Available Seats");
        int availableSeats = App.scan.nextInt();
        App.scan.nextLine();

        System.out.println("Enter Route ID");
        int routeID = App.scan.nextInt();
        App.scan.nextLine();

        String query = "insert into Bus (busName,busCapacity,busAvailableSeats,routeID) values(?,?,?,?)";

        try (Connection connection = DataBaseConnection.getConnection();
                PreparedStatement p = connection.prepareStatement(query)) {

            p.setString(1, name);
            p.setInt(2, capacity);
            p.setInt(3, availableSeats);
            p.setInt(4, routeID);

            int row = p.executeUpdate();
            System.out.println("User added successfully. Rows affected: " + row);
            p.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void viewBuses() {
        String query = "select * from Bus";

        try (Connection connection = DataBaseConnection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(query)) {

            while (rs.next()) {

                System.out.println("Bus ID: " + rs.getInt(1));
                System.out.println("Bus Name: " + rs.getString(2));
                System.out.println("Capacity: " + rs.getInt(3));
                System.out.println("Available Seats: " + rs.getInt(4));
                System.out.println("Route ID: " + rs.getInt(5));

            }
            connection.close();
            statement.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
