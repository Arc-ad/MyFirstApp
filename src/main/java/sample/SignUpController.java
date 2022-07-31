package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signUoButton;

    @FXML
    private CheckBox signUpCheckBoxFemale;

    @FXML
    private CheckBox signUpCheckBoxMale;

    @FXML
    private TextField signUpCountry;

    @FXML
    private TextField signUpLastName;

    @FXML
    private TextField signUpName;

    @FXML
    void initialize() {

        signUoButton.setOnAction(ActionEvent -> {
            singUpNewUser();



        });


    }

    private void singUpNewUser() {
        DateBaseHandler dbHandler = new DateBaseHandler();

        String firstName = signUpName.getText();
        String lastName = signUpLastName.getText();
        String userName = loginField.getText();
        String password = passwordField.getText();
        String location = signUpCountry.getText();
        String gender = "";
        if(signUpCheckBoxMale.isSelected())
            gender = "Мужской";
        else gender = "Женский";
        User user = new User(firstName, lastName, userName, password, location, gender);
        dbHandler.signUpUser(user);
    }

}
