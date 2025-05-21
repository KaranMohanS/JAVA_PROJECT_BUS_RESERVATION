package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.App;
import com.DataBaseConnection;

public class UserDataBaseService {

    public static void addUser() {

        System.out.println("Enter Name:");
        String name = App.scan.nextLine();

        System.out.println("Enter Contact Number:");
        long contact = App.scan.nextLong();
        App.scan.nextLine();

        System.out.println("Enter Email:");
        String email = App.scan.nextLine();

        String query = "INSERT INTO user (name, ph, email) VALUES ( ?, ?, ?)";

        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement p = connection.prepareStatement(query);
            p.setString(1, name);
            p.setLong(2, contact);
            p.setString(3, email);

            int row = p.executeUpdate();
            System.out.println("User added successfully. Rows affected: " + row);

            connection.close();
            p.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewUser() {
        String query = "select * from user";

        try {
            Connection connection = DataBaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.println("------ User Details ------");
                System.out.println("User ID: " + rs.getInt(1));
                System.out.println("Name: " + rs.getString(2));
                System.out.println("Phone: " + rs.getLong(3));
                System.out.println("Email: " + rs.getString(4));
            }
            connection.close();
            statement.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getUser() {
        System.out.println("Enter user ID");
        int id = App.scan.nextInt();
        App.scan.nextLine();

        String query = " select * from user where id=?";
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement p = connection.prepareStatement(query);
            p.setInt(1, id);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                System.out.println("------ User Details ------");
                System.out.println("User ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Phone: " + rs.getLong("ph"));
                System.out.println("Email: " + rs.getString("email"));
            }
            connection.close();
            p.close();
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
