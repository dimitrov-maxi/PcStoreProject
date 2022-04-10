package com.example.pcstoreproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import static com.example.pcstoreproject.Connection.dbURL;

public class AdminPage implements Initializable{

    @FXML
    private Stage stage;
    @FXML
    private TableView<CPU> CPUInfo;
    @FXML
    private TableColumn<CPU, String> CPUNameColumn;
    @FXML
    private TableColumn<CPU, Integer> CPUQuantityColumn;
    @FXML
    private TableColumn<CPU, Double> CPUPriceColumn;

    @FXML
    void logOut(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LoginPanel.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<CPU> CPUList = null;
        try {
            java.sql.Connection conn;
            conn = DriverManager.getConnection(dbURL);
            String query = "SELECT Model, Quantity, Price FROM CPUs";
            PreparedStatement showCPUTable = conn.prepareStatement(query);

            ResultSet result = showCPUTable.executeQuery();

            CPUList = FXCollections.observableArrayList();
            while (result.next()) {
                CPUList.add(new CPU(
                        result.getString("Model"),
                        result.getInt("Quantity"),
                        result.getDouble("Price")));
            }

            conn.close();
        } catch (Exception ConnErr) {
            System.out.print("Did not connect to DB - Error: " + ConnErr);
        }
        CPUNameColumn.setCellValueFactory(new PropertyValueFactory<>("Model"));
        CPUQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        CPUPriceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));

        CPUInfo.setItems(null);
        CPUInfo.setItems(CPUList);
    }
}

