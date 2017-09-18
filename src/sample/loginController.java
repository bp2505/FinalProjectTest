package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import static sample.signupController.data;
import static sample.signupController.fileName;

public class loginController {
    @FXML
    TextField id;
    @FXML
    TextField password;
    public void authentication() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));
        data = (ArrayList<User>) is.readObject();
        User current = data.get(0);
        if(id.getText().equalsIgnoreCase(current.getUsername())){
            System.out.println("log in successful");
        }
        else
            System.out.println("Wrong info");




    }

    public void signup(ActionEvent actionEvent) throws Exception {
        Stage primaryStage = (Stage)((Hyperlink)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
        primaryStage.setTitle("signup");
        primaryStage.setScene(new Scene(root,400,275));
        primaryStage.show();
    }
}
