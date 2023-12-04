package com.example.spellinggame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class CasualGame extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(NormalGame.class.getResource("CasualGame.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 970, 600);
        stage.setTitle("Spelling Bee");
        Image image = new Image("icon.png");
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}
