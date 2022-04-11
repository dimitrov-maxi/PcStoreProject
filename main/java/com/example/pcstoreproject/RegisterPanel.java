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

import static com.example.pcstoreproject.Connection.insertUser;

public class RegisterPanel {
    @FXML
    private Stage stage;
    @FXML
    private TextField emailInfo;
    @FXML
    private PasswordField passInfo;
    @FXML
    private PasswordField passInfoVerifier;

    @FXML
    void goBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("UserPanel.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void registerCheck(){
        String email = emailInfo.getText();
        String password = passInfo.getText();
        String passVerifier = passInfoVerifier.getText();

        if (password.length() >= 4){
            if(password.equals(passVerifier)){
                System.out.println("Successfully registered!");
                String addUserQuery = "INSERT INTO UserInfo('email', 'password') values ( '" + email + "', '" + password + "');";
                insertUser(addUserQuery);
            }else System.out.println("The passwords don't match!");
        }else System.out.println("Not enough symbols!");
    }
}
