package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class signupController {
    @FXML
    TextField uname;
    @FXML
    TextField upassword;
    @FXML
    TextField repass;
    @FXML
    TextField fname;
    @FXML
    TextField lname;
    public static ArrayList<User> data = new ArrayList();
    public static String fileName = "data.bin";


    public void Create() throws Exception {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
        if (upassword.getText().equalsIgnoreCase(repass.getText())) {
            User user = new User(uname.getText(), upassword.getText());
            user.setLastname(lname.getText());
            user.setFirstname(fname.getText());
            data.add(user);
            os.writeObject(data);
            os.close();
        }
    }

    public void login(ActionEvent actionEvent) throws Exception {
        Stage primaryStage = (Stage)((Hyperlink)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("login");
        primaryStage.setScene(new Scene(root,400,275));
        primaryStage.show();
    }
}