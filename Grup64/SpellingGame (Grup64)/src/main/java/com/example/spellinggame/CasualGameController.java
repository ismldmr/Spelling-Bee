package com.example.spellinggame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class CasualGameController{

    @FXML
    private TextField text;
    @FXML
    private Label warming;

    private String word;

    @FXML
    public void Control() throws IOException
    {
        ArrayList<Character> letters = new ArrayList<>();
        if (text.getText().length()==7 && text.getText().matches("^[a-zA-Z0-9ğüşöçıİĞÜŞÖÇ]+$"))
        {
           for (int i=0;i<7;i++){letters.add(text.getText().charAt(i));}

           if (letters.stream().distinct().count()==7)
           {
               word = text.getText();
               if (EligibleWords().size()<20)
               {warming.setText("GİRİLEN HARFLERLE OYUN BULUNAMADI");text.setText(null);}
               else {
                   FXMLLoader loader = new FXMLLoader(getClass().getResource("CasualGame.fxml"));
                   Parent root = (Parent) loader.load();

                   NormalGameController normalGameController = loader.getController();
                   normalGameController.getCasualText(word);
                   Stage stage = new Stage();
                   stage.setScene(new Scene(root));
                   stage.setResizable(false);
                   stage.show();
               }
           }
           else warming.setText("7 FARKLI HARF GİRİNİZ");
        }
        else warming.setText("ÖZEL KARAKTER İÇERMEYEN 7 HARF GİRİNİZ");
    }
    public ArrayList<String> EligibleWords()
    {
        GameStarter gameStarter = new GameStarter(text.getText());
        gameStarter.GameGenerator();
        return gameStarter.GameWords;
    }
}
