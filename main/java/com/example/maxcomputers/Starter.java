package com.example.maxcomputers;

        import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.stage.Stage;

        import java.io.IOException;

        import static com.example.maxcomputers.Connection.connect;

public class Starter extends Application {
            @Override
            public void start(Stage stage){
                try{
                Parent root = FXMLLoader.load(getClass().getResource("LoginPanel.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

        }catch (Exception e){
                    e.printStackTrace();
                }
    }

        public static void main(String[] args) {
                connect();
                launch();
        }
    }

