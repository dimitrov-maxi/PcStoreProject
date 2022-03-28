module com.example.maxcomputers {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.maxcomputers to javafx.fxml;
    exports com.example.maxcomputers;
}