package com;

import java.sql.DriverManager;
import java.sql.Connection;;

public class DataBaseConnection {

    private static final String path = "jdbc:mysql://localhost:3306/bus";
    private static final String username = "root";
    private static final String password = "1234";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(path, username, password);
    }

}
