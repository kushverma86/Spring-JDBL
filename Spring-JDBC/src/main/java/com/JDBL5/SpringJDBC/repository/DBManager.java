package com.JDBL5.SpringJDBC.repository;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

    private static Connection connection = null;

    private DBManager(){

    }

    private static void init(){
        String user = "root";
        String pass = "Skell@m@i1996";
        String hostport = "127.0.0.1:3306";
        String userDb = "userdb";
        try {
            String connectionURL = "jdbc:mysql://" +hostport+ "/" + userDb;
            connection = DriverManager.getConnection(connectionURL, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            if (connection == null || connection.isClosed()){
                init();
            }
        } catch (SQLException e) {
            init();
        }
        return connection;
    }

}
