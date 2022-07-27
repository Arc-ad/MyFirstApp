package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("sample.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        stage.setTitle("MyFirstApp!");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);      //нельзя изменять размер окна
        stage.setOnCloseRequest(e -> {      //при закрытии окна - закрывается приложение
            Platform.exit();
            System.exit(0);
        });
    }


    public static void main(String[] args) {
//java -classpath c:\Java\mysql-connector-java-8.0.11.jar;c:\Java Program
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            System.out.println("Connection succesfull!");
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
        launch();

    }
}