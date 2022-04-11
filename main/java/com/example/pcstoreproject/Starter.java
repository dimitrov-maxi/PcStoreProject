package com.example.pcstoreproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.pcstoreproject.Connection.connect;

public class Starter extends Application {
    @Override
    public void start(Stage stage){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("LoginPanel.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }catch (Exception e){
            System.out.println("Problems with loading the FXML file "+ e);
        }
    }

    public static void main(String[] args) {
        connect();
        launch();
    }
}