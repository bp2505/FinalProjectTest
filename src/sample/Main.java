package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent login = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("Log-in");
        primaryStage.setScene(new Scene(login, 400, 235));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
