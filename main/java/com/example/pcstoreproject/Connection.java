package com.example.pcstoreproject;

import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connection {
    //=============================================================================================================
    static String dbURL = "jdbc:sqlite:F:\\Programming\\SQLite\\SQL\\Databases\\Computers.db";

    public static void connect() {
        try {
            java.sql.Connection conn = null;
            conn = DriverManager.getConnection(dbURL);

            System.out.println("Connection successful!");
            conn.close();
        } catch (Exception ConnErr) {
            System.out.print("Did not connect to DB - Error: " + ConnErr);
        }
    }
    //=============================================================================================================
//    public static void printUserInfo(){
//        try{
//            java.sql.Connection conn = null;
//            conn = DriverManager.getConnection(dbURL);
//            String printUsers = "SELECT * FROM UserInfo";
//            PreparedStatement UI = conn.prepareStatement(printUsers);
//            UI.executeQuery(printUsers);
//            ResultSet result = UI.executeQuery(printUsers);
//
//            while (result.next()) {
//                String email = result.getString("email");
//                String password = result.getString("password");
//
//
//                System.out.println(email + " | " + password);
//            }
//            conn.close();
//        } catch (Exception ConnErr) {
//            System.out.print("Did not connect to DB - Error: " + ConnErr);
//        }
//    }

    public static boolean checkAdmins(String email, String password) {
        try {
            java.sql.Connection conn = null;
            conn = DriverManager.getConnection(dbURL);
            String query = "SELECT * FROM AdminInfo WHERE email = ? and password = ?;";
            PreparedStatement loginCheck = conn.prepareStatement(query);
            loginCheck.setString(1, email);
            loginCheck.setString(2, password);
            ResultSet result = loginCheck.executeQuery();

            if (result.next()) {
                return true;
            }
            conn.close();
        } catch (Exception ConnErr) {
            System.out.print("Did not connect to DB - Error: " + ConnErr);
        }
        return false;

    }

    public static boolean checkUsers(String email, String password) {
        try {
            java.sql.Connection conn = null;
            conn = DriverManager.getConnection(dbURL);
            String query = "SELECT * FROM UserInfo WHERE email = ? and password = ?;";
            PreparedStatement loginCheck = conn.prepareStatement(query);
            loginCheck.setString(1, email);
            loginCheck.setString(2, password);
            ResultSet result = loginCheck.executeQuery();

            if (result.next()) {
                return true;
            }
            conn.close();
        } catch (Exception ConnErr) {
            System.out.print("Did not connect to DB - Error: " + ConnErr);
        }
        return false;

    }

    public static void insertUser(String addUserQuery) {
        try {
            java.sql.Connection conn = null;
            conn = DriverManager.getConnection(dbURL);
            PreparedStatement InsertUser = conn.prepareStatement(addUserQuery);
            InsertUser.executeUpdate();
            conn.close();
        } catch (Exception ConnErr) {
            System.out.print("Did not connect to DB - Error: " + ConnErr);
        }
    }
}