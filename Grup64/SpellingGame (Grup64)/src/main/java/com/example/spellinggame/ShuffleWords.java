package com.example.spellinggame;

import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.Collections;

public class ShuffleWords {
    private ArrayList<Button> Buttons;
    ArrayList<Character> Letters;
    public ShuffleWords(ArrayList<Button> buttons) {
        this.Buttons = buttons;
    }

    private void Mix() {
        Letters = new ArrayList<Character>();
        for (int i = 0; i < Buttons.size(); i++) {
            Letters.add(Buttons.get(i).getText().charAt(0));
        }
        Collections.shuffle(Letters);

    }
    public void getButtons(){
        if (Buttons.size()==7) Buttons.remove(0);
        Mix();
        for (int i = 0; i < Buttons.size(); i++) {
            Buttons.get(i).setText(Letters.get(i).toString());
        }
    }
}
