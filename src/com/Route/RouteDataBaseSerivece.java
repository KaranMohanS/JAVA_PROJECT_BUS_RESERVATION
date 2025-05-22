package com.Route;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

import com.DataBaseConnection;

public class RouteDataBaseSerivece {
    

    public static void viewRoutes()
    {
        String query="select * from Route";
        try {
            Connection connection=DataBaseConnection.getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(query);

            while (rs.next()) {
                
                System.out.println("Route ID: "+rs.getInt(1));
                System.out.println("Starting Point: "+rs.getString(2));
                System.out.println("");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
