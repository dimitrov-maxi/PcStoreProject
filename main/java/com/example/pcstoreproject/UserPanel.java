package com.example.pcstoreproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.pcstoreproject.Connection.checkUsers;

public class UserPanel {
    @FXML
    private TextField emailInfo;
    @FXML
    private PasswordField passInfo;
    @FXML
    private Stage stage;

    @FXML
    void goBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LoginPanel.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void loginCheck(ActionEvent event) throws IOException{
        String email = emailInfo.getText();
        String password = passInfo.getText();

        if (checkUsers(email, password)) {
            System.out.println("You logged in!");
            switchToPage(event);
        }else{
            System.out.println("Invalid email or password!");
        }
    }
    @FXML
    private void switchToPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("StorePage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void registerButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RegisterPanel.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}