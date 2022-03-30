module com.example.pcstoreproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.pcstoreproject to javafx.fxml;
    exports com.example.pcstoreproject;

}