package com.example.maxcomputers;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connection {
        public static void connect() {
            try{
        java.sql.Connection conn = null;
        conn = DriverManager.getConnection("jdbc:sqlite:F:\\Programming\\SQLite\\SQL\\Databases\\MaxComputers.db");

                System.out.println("Connection successful!");
                conn.close();
    } catch (Exception ConnErr) {
        System.out.print("Did not connect to DB - Error: " + ConnErr);
    }
    }
    public static void printUserInfo(){
        try{
            java.sql.Connection conn = null;
            conn = DriverManager.getConnection("jdbc:sqlite:F:\\Programming\\SQLite\\SQL\\Databases\\MaxComputers.db");
            String printUsers = "SELECT * FROM UserInfo";
            PreparedStatement UI = conn.prepareStatement(printUsers);
            UI.executeQuery(printUsers);
            ResultSet result = UI.executeQuery(printUsers);

            while (result.next()) {
                String email = result.getString("email");
                String password = result.getString("password");


                System.out.println(email + " | " + password);
            }
            conn.close();
        } catch (Exception ConnErr) {
            System.out.print("Did not connect to DB - Error: " + ConnErr);
        }
    }
}
