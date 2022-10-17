package mss.modern_school_system;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MSSApplication extends Application {

    public static Stage primaryStage = null;

    @Override
    public void start(Stage stage) throws IOException {
        MSSApplication.primaryStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(MSSApplication.class.getResource("fxml/welcome.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("images/bobfilogo.png")));
        stage.setResizable(false);
        stage.show();
        scene.getWindow().centerOnScreen();
    }

    public static void main(String[] args) {
        launch(args);
    }
}