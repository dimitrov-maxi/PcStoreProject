module com.example.maxcomputers {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.maxcomputers to javafx.fxml;
    exports com.example.maxcomputers;
}