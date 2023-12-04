package com.example.spellinggame;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;


public class NormalGameController implements Initializable {



    @FXML
    private TextField InputWord,Text;
    @FXML
    private Label FoundWords,Remaining;
    @FXML
    private Button CenterButton,FirstButton,SecondButton,ThirdButton,FourthButton,FifthButton,SixthButton,Start,Enter,CasualStart;
    @FXML
    private ProgressBar counterBar;


    private ArrayList<String> founds = new ArrayList<>();
    private ArrayList<String> LocalGameWords;
    private char center;
    private String casualText;

    PangramFinder pangramFinder ;
    GameStarter gameStarter ;

    /*Letter Buttons*/
    @FXML
    private void CenterLetter() { InputWord.appendText(CenterButton.getText());}
    @FXML
    private void FirstLetter(){ InputWord.appendText(FirstButton.getText()); }
    @FXML
    private void SecondLetter(){
        InputWord.appendText(SecondButton.getText());
    }
    @FXML
    private void ThirdLetter(){
        InputWord.appendText(ThirdButton.getText());
    }
    @FXML
    private void FourthLetter(){
        InputWord.appendText(FourthButton.getText());
    }
    @FXML
    private void FifthLetter(){
        InputWord.appendText(FifthButton.getText());
    }
    @FXML
    private void SixthLetter(){
        InputWord.appendText(SixthButton.getText());
    }



    /*ENTER-DELETE Buttons*/
    @FXML
    private void Enter(){

        Alert alert = new Alert(Alert.AlertType.WARNING);
        if (InputWord.getText().length()<=3){
            alert.setTitle("Uzunluk Uyarısı");
            alert.setHeaderText("Girilen kelime 3 harften uzun olmalıdır");
            alert.show();
        }
        else{
            if (InputWord.getText().toUpperCase(Locale.forLanguageTag("tr")).contains(CenterButton.getText()))
            {
                if (!founds.contains(InputWord.getText().toString().toUpperCase(Locale.forLanguageTag("tr"))))
                {
                    boolean doesContain = false;

                    for (int i=0;i<LocalGameWords.size();i++)
                    {
                        if(InputWord.getText().toString().toUpperCase(Locale.forLanguageTag("tr")).equals(LocalGameWords.get(i).toString()))
                        {
                            doesContain = true;
                            break;
                        }
                    }
                    if (doesContain)
                    {
                        founds.add(InputWord.getText().toString().toUpperCase(Locale.forLanguageTag("tr")));
                        double count = 1.0 /LocalGameWords.size();
                        Remaining.setText("Kalan Kelime = "+(LocalGameWords.size()-founds.size()));
                        counterBar.setProgress(count*founds.size());
                        InputWord.setText(null);
                        InputWord.setPromptText("TEBRİKLER");
                    }
                    else {InputWord.setText(null); InputWord.setPromptText("KELİME BULUNAMADI");}
                }

                for (int j = 0; j< founds.size();j++)
                {
                    FoundWords.setText(founds.toString().toUpperCase(Locale.forLanguageTag("tr")));
                }
            }
            else{
                alert.setTitle("Merkez Harf Hatası");
                alert.setHeaderText("Girilen kelime merkez harfi içermelidir ");
                alert.show();
            }
        }
    }
    @FXML
    private void Delete() {
        if (InputWord.getLength() != 0) {
            String newInput = InputWord.getText().substring(0, InputWord.getLength() - 1);
            InputWord.setText(newInput);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Deletion error");
            alert.setHeaderText("Text is already empty.");
            alert.show();
        }
    }

    @FXML
    private void Shuffle (){
        ShuffleWords shuffleWords = new ShuffleWords(addButtons());
        shuffleWords.getButtons();

    }

    private ArrayList<Button> addButtons()
    {
        ArrayList<Button> LetterButtons = new ArrayList<>();
        LetterButtons.add(CenterButton);
        LetterButtons.add(FirstButton);LetterButtons.add(SecondButton);LetterButtons.add(ThirdButton);
        LetterButtons.add(FourthButton);LetterButtons.add(FifthButton);LetterButtons.add(SixthButton);
        return LetterButtons;
    }
    @FXML
    private void Start () {
        Start.setText("Yeni Oyun Başlat");
        FoundWords.setText(null);
        founds.clear();
        InputWord.setText(null);
        counterBar.setProgress(0);
        LocalGameWords = new ArrayList<>();
        LocalGameWords.clear();
        pangramFinder = new PangramFinder();
        pangramFinder.bind();
        gameStarter=new GameStarter(pangramFinder.randomPangram);
        gameStarter.GameGenerator();
        setButtonsText setButtonsText = new setButtonsText(addButtons(), pangramFinder.randomPangram);
        setButtonsText.getLetters();
        center = setButtonsText.Buttons.get(0).getText().charAt(0);
        makeGameReady(20);
    }
    private void makeGameReady(int minbound)
    {
        boolean isContain = false;

        for (int i = 0;i< gameStarter.GameWords.size();i++)
        {
            isContain = false;
            for (int j = 0;j<gameStarter.GameWords.get(i).length();j++)
            {
                isContain=gameStarter.GameWords.get(i).charAt(j)==center;
            }
            if (isContain)
                LocalGameWords.add(gameStarter.GameWords.get(i));
        }

        if (LocalGameWords.size()<minbound)
            Start();
        PangramFinder pangramFinder = new PangramFinder();
        while (LocalGameWords.size()>80)
        {
            LocalGameWords.remove(pangramFinder.RandGen(LocalGameWords.size()));
        }
        if (!LocalGameWords.contains(gameStarter.WordOfIX))
        {
            LocalGameWords.remove(pangramFinder.RandGen(LocalGameWords.size()));
            LocalGameWords.add(gameStarter.WordOfIX.toUpperCase(Locale.forLanguageTag("tr")));
        }
        Remaining.setText("Kalan Kelime = "+ LocalGameWords.size());
        for (String string : LocalGameWords)
            System.out.println(string);
    }

    @FXML
    private void CasualStart() throws IOException {
        CasualStart.setText("Merkez Harfi Değiştir");
        FoundWords.setText(null);
        founds.clear();
        InputWord.setText(null);
        counterBar.setProgress(0);
        LocalGameWords = new ArrayList<>();
        LocalGameWords.clear();
        gameStarter = new GameStarter(casualText);
        gameStarter.GameGenerator();
        setButtonsText setButtonsText = new setButtonsText(addButtons(), casualText);
        setButtonsText.getLetters();
        center = setButtonsText.Buttons.get(0).getText().charAt(0);
        makeGameReady(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void getCasualText(String text)
    {
        casualText =text;
    }

}