package com.example.pcstoreproject;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import static com.example.pcstoreproject.Connection.insertUser;

public class RegisterPanel {
    @FXML
    private TextField emailInfo;
    @FXML
    private PasswordField passInfo;
    @FXML
    private PasswordField passInfoVerifier;

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
