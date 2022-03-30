package com.example.pcstoreproject;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Connection {
    //=============================================================================================================
    static String dbURL = "jdbc:sqlite:/home/maxi/SQL/Databases/Computers.db";
    public static void connect() {
        try{
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

    public static boolean checkAdmins(String email, String password){
        try{
            java.sql.Connection conn = null;
            conn = DriverManager.getConnection(dbURL);
            String query = "SELECT * FROM AdminInfo WHERE email = ? and password = ?;";
            PreparedStatement loginCheck = conn.prepareStatement(query);
            loginCheck.setString(1,email);
            loginCheck.setString(2,password);
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
    //=============================================================================================================
//    public static void checkUserInfo(){
//        try{
//            java.sql.Connection conn = null;
//            conn = DriverManager.getConnection(dbURL);
//            String printUsers = "";
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
}