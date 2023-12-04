package com.example.spellinggame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

import javafx.stage.Stage;

import java.io.IOException;


public class MainController  {

    public javafx.scene.layout.Pane Pane;
    @FXML
    private Button NormalGame,CasualGame;

    public void CasualGame () throws IOException {

        CallNewForm("LettersForCasual.fxml",600,400);
    }

    public void NormalGame() throws IOException {

        CallNewForm("GamePage.fxml",970,600);


    }
    public void CallNewForm(String name,int s1,int s2) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(NormalGame.class.getResource(name));
        Scene GameScene = new Scene(fxmlLoader.load(), s1, s2);
        Stage GameStage = new Stage();
        GameStage.setTitle("Spelling Bee");
        Image image = new Image("icon.png");
        GameStage.getIcons().add(image);
        GameStage.setScene(GameScene);
        GameStage.show();
        GameStage.setResizable(false);
        Stage MainStage = (Stage) Pane.getScene().getWindow();
        MainStage.close();
    }
}
