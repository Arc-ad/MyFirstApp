package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private Button butInSample;


    @FXML
    void initialize() {
        butInSample.setOnAction(actionEvent -> {
            System.out.println("asd");
            openNewScene("/sample/sample.fxml");
        });

    }
    public void openNewScene(String window)
    {
        butInSample.getScene().getWindow().hide();        //закрытие основного окна
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
