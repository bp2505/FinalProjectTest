package FinalProject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import MyList.MyArrayList;


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
    @FXML
    TextField phoneNumber;
    @FXML
    Button browseBtn;
    @FXML
    ImageView picView;
    @FXML
    ChoiceBox genderPick;
    public static MyArrayList<User> data = new MyArrayList<User>();
    public static String dataBin = "data.bin";
    public User user = new User();


    public void Create() throws Exception {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(dataBin));

        for (int x = 0; x <= data.size()-1; x++) {
            if (data.get(x).getEmail().equalsIgnoreCase(uname.getText())) {
                Alert a1 = new Alert(Alert.AlertType.ERROR);
                a1.setContentText("same email already exists");
                a1.show();
            }
        }
        if (upassword.getText().equals(repass.getText())) {
            if ((upassword.getText().matches("[0-9a-zA-Z]+"))) {

                user = new User(uname.getText(), upassword.getText());
                user.setLastname(lname.getText());
                user.setFirstname(fname.getText());
                user.setEmail(uname.getText());
                user.setLastname(lname.getText());
                user.setFirstname(fname.getText());

                data.add(user);
                os.writeObject(data);
                os.close();


                if (uname.getText().matches(".+[@].+[.].+")) {
                    user.setEmail(uname.getText());
                }
                else {
                    Alert a3 = new Alert(Alert.AlertType.ERROR);
                    a3.setContentText("email must be valid");
                    a3.show();
                }
            } else {
                Alert a1 = new Alert(Alert.AlertType.ERROR);
                a1.setContentText("must contain special,upper,lower, and a number");
                a1.show();
                System.gc();
            }
        } else {
            Alert a1 = new Alert(Alert.AlertType.ERROR);
            a1.setContentText("passwords do not match");
            a1.show();
        }
        if (phoneNumber.getText().matches("[0-9]{10}")) {
            Alert a1 = new Alert(Alert.AlertType.ERROR);
            a1.setContentText("phone number is invalid");
            a1.show();
        }
        //user.setGender((String) genderPick.getValue());

    }

    public void login(ActionEvent actionEvent) throws Exception {
        Stage primaryStage = (Stage) ((Hyperlink) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("login");
        primaryStage.setScene(new Scene(root, 400, 275));
        primaryStage.show();
        //genderPick = test;

    }

    public void browseFile(ActionEvent e) throws Exception {
        Stage primaryStage = (Stage)((Node)e.getSource()).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("File Chooser");
        File file = fileChooser.showOpenDialog(primaryStage);
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
        if (file != null){
            Image pic = new Image(file.toURL().toString());
            picView.setImage(pic);
            user.setPropicpth(file.toURL().toString());

        }

    }
}
