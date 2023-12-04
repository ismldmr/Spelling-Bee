package com.example.spellinggame;

import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class setButtonsText {
    public ArrayList<Button> Buttons;
    public String word;

    public setButtonsText(ArrayList<Button> buttons, String word) {
        this.Buttons = buttons;
        this.word = word;
    }

    public void getLetters() {

        ArrayList<Character> Letters = new ArrayList<Character>();
        for (int i = 0; i < word.length(); i++) {
            Letters.add(word.charAt(i));
        }
        setButtons(Letters);
    }
    private void setButtons(ArrayList<Character> letters) {

        for (int i = 0; i < letters.size(); i++) {

            for (int j = i + 1; j < letters.size(); j++) {
                if (letters.get(i).equals(letters.get(j))) {
                    letters.remove(j);
                }
            }
            System.out.println(letters.get(i));
            Buttons.get(i).setText(letters.get(i).toString().toUpperCase(Locale.forLanguageTag("tr")));
        }
        Collections.shuffle(letters);

        for (int i = 0; i < Buttons.size(); i++) {
            Buttons.get(i).setText(letters.get(i).toString().toUpperCase(Locale.forLanguageTag("tr")));
        }
    }
}
