package com.Route;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.App;
import com.DataBaseConnection;

public class RouteDataBaseSerivece {

    public static void addRoute() {

        System.out.println("Enter Starting Point");
        String sP = App.scan.nextLine();

        System.out.println("Enter Starting Time");
        String sT = App.scan.nextLine();

        System.out.println("Enter ending Point");
        String eP = App.scan.nextLine();

        System.out.println("Enter ending Time");
        String eT = App.scan.nextLine();

        System.out.println("Enter Distance");
        double dis = App.scan.nextDouble();
        App.scan.nextLine();

        System.out.println("Enter Date");
        String date = App.scan.nextLine();

        String query = "INSERT INTO Route(startPoint,startTime,endPoint,endTime,distance,date) values (?,?,?,?,?,?)";

        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement p = connection.prepareStatement(query);
            p.setString(1, sP);
            p.setString(2, sT);
            p.setString(3, eP);
            p.setString(4, eT);
            p.setDouble(5, dis);
            p.setString(6, date);

            int row = p.executeUpdate();
            System.out.println("User added successfully. Rows affected: " + row);

            connection.close();
            p.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void viewRoutes() {
        String query = "select * from Route";
        try {
            Connection connection = DataBaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {

                System.out.println("Route ID: " + rs.getInt(1));
                System.out.println("Starting Point: " + rs.getString(2));
                System.out.println("Starting Time: " + rs.getString(3));
                System.out.println("ending Point: " + rs.getString(4));
                System.out.println("ending Time: " + rs.getString(5));
                System.out.println("Distance: " + rs.getDouble(6));
                System.out.println("Date: " + rs.getString("date"));
            }
            connection.close();
            statement.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getRoute() {
        System.out.println("Enter Route ID");
        int routeID = App.scan.nextInt();
        App.scan.nextLine();

        String query = "select * from Route where routeID=?";

        try (Connection connection = DataBaseConnection.getConnection();
                PreparedStatement p = connection.prepareStatement(query)) {
            p.setInt(1, routeID);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                System.out.println("Route ID: " + rs.getInt(1));
                System.out.println("Starting Point: " + rs.getString(2));
                System.out.println("Starting Time: " + rs.getString(3));
                System.out.println("ending Point: " + rs.getString(4));
                System.out.println("ending Time: " + rs.getString(5));
                System.out.println("Distance: " + rs.getDouble(6));
                System.out.println("Date: " + rs.getString("date"));
            } else {
                System.err.println("Route ID Invalid: " + routeID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteRoute() {
        System.out.println("Enter Route ID");
        int routeID = App.scan.nextInt();
        App.scan.nextLine();

        String deleteBusQuery = "DELETE FROM Bus WHERE routeID = ?";
        String deleteRouteQuery = "DELETE FROM Route WHERE routeID = ?";

        try (Connection connection = DataBaseConnection.getConnection()) {
            // First delete buses with this route
            try (PreparedStatement busStmt = connection.prepareStatement(deleteBusQuery)) {
                busStmt.setInt(1, routeID);
                busStmt.executeUpdate();
            }

            // Then delete the route
            try (PreparedStatement routeStmt = connection.prepareStatement(deleteRouteQuery)) {
                routeStmt.setInt(1, routeID);
                int row = routeStmt.executeUpdate();
                if (row > 0) {
                    System.out.println("Route deleted successfully.");
                } else {
                    System.out.println("Route ID not found.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
