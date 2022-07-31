package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.animation.Shake;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button authSignInButton;

    @FXML
    private TextField loginField;

    @FXML
    private Button loginSignUpButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    void initialize() {
        authSignInButton.setOnAction(actionEvent ->
        {
        String loginText = loginField.getText().trim();
        String loginPassword = passwordField.getText().trim();

        if(!loginText.equals("") && !loginPassword.equals("")){
            loginUser(loginText, loginPassword);
        }
        else System.out.println("Login or password is empty!");

        }  );
        loginSignUpButton.setOnAction(actionEvent -> {
           openNewScene("/sample/signUp.fxml");

        });
    }

    private void loginUser(String loginText, String loginPassword) {
        DateBaseHandler dbHandler = new DateBaseHandler();
        User user = new User();
        user.setUserName(loginText);
        user.setPassword(loginPassword);
        ResultSet result = dbHandler.getUser(user);
        int counter = 0;
        while (true){
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            counter++;
        }
        if(counter>= 1){
            System.out.println("Success!");
            openNewScene("/sample/app.fxml");
        }
        else {
            Shake userLoginAnim = new Shake(loginField);
            Shake userPassAnim = new Shake(passwordField);
            userLoginAnim.playAnim();
            userPassAnim.playAnim();
        }
    }
    public void openNewScene(String window)
    {
        loginSignUpButton.getScene().getWindow().hide();        //закрытие основного окна
        FXMLLoader loader = new FXMLLoader();       //новое окно
        loader.setLocation(getClass().getResource(window));      //передаем путь к этому окну
        try {
            loader.load();      //загружаем этот файл
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();     //путь к файлу который нам нужно загрузить
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();        //показать и подождать пока окно отобразится

    }
}
