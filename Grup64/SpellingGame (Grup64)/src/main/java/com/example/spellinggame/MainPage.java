package com.example.spellinggame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPage extends Application {

    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(NormalGame.class.getResource("MainTheme.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 460);
        primaryStage.setTitle("Spelling Bee");
        Image image = new Image("icon.png");
        primaryStage.getIcons().add(image);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}