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

}
