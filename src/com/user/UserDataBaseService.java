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
            if (rs.next()) {
                System.out.println("------ User Details ------");
                System.out.println("User ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Phone: " + rs.getLong("ph"));
                System.out.println("Email: " + rs.getString("email"));
            } else {
                System.out.println("User ID " + id + " not found.");
            }
            connection.close();
            p.close();
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void updateUser() {
        System.out.println("Enter user ID");
        int id = App.scan.nextInt();
        App.scan.nextLine();

        String query = " ";

        System.out.println("Enter choice | 1 Name | 2 Contact | 3 Email |");
        int option = App.scan.nextInt();
        App.scan.nextLine();

        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement p = null;

            switch (option) {
                case 1:
                    System.out.println("Enter new Name");
                    String name = App.scan.nextLine();
                    query = "update user set name=? where id=?";
                    p = connection.prepareStatement(query);
                    p.setString(1, name);
                    p.setInt(2, id);
                    break;

                case 2:
                    System.out.println("Enter new Contect");
                    long ph = App.scan.nextLong();
                    App.scan.nextLine();
                    query = "update user set ph=? where id=?";
                    p = connection.prepareStatement(query);
                    p.setLong(1, ph);
                    p.setInt(2, id);
                    break;

                case 3:
                    System.out.println("Enter new Email");
                    String email = App.scan.nextLine();
                    query = "update user set email=? where id=?";
                    p = connection.prepareStatement(query);
                    p.setString(1, email);
                    p.setInt(2, id);
                    break;

                default:
                    System.out.println("Invalid option: " + option);
                    break;
            }

            int rows = p.executeUpdate();
            if (rows > 0) {
                System.out.println("User details updated successfully.");
            } else {
                System.out.println("User ID not found.");
            }

            connection.close();
            p.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteUser() {
        System.out.println("Enter user ID");
        int id = App.scan.nextInt();
        App.scan.nextLine();

        String query = "delete from user where id=?";

        try (Connection connection = DataBaseConnection.getConnection();
                PreparedStatement p = connection.prepareStatement(query)) {

            p.setInt(1, id);
            int row = p.executeUpdate();

            if (row > 0) {
                System.out.println("User deleted successfully.");
            } else {
                System.out.println("User ID not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
