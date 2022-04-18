package com.example.pcstoreproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


import static com.example.pcstoreproject.Connection.addToCart;

public class StorePage {
    @FXML
    private Stage stage;
    @FXML
    void orderCPUi3(){
        String model = "i3-9100f";
        addToCart(model);
    }
    @FXML
    void orderCPUi5(){
        String model = "i5-9600kf";
        addToCart(model);
    }
    @FXML
    void logOut(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LoginPanel.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
