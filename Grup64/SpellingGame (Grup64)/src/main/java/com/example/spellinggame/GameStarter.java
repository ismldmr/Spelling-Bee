package com.example.spellinggame;

import java.util.ArrayList;
import java.util.Locale;


public class GameStarter{

    ArrayList<String> GameWords = new ArrayList<>();
    String WordOfIX;
    PangramFinder pangramFinder = new PangramFinder();

    public GameStarter(String WordOfIx){
        this.WordOfIX = WordOfIx;}

    public char[] wordsLetter(String word)
    {
        char[] Letters = new char[word.length()];

        for (int i = 0 ; i<word.length();i++)
        {
            Letters[i]=word.charAt(i);
        }
        return Letters;
    }

    public void GameGenerator ()
    {
        int counter = 0;

        pangramFinder.FindPangram();

        System.out.println("\n"+WordOfIX+"\n");

        for (int i = 0;i<pangramFinder.ReadWords.size();i++)
        {

            for (int f = 0;f<pangramFinder.ReadWords.get(i).length();f++)
            {
                for (int j = 0;j<WordOfIX.length();j++)
                {
                    if (wordsLetter(WordOfIX)[j] == wordsLetter(pangramFinder.ReadWords.get(i))[f] ){

                        counter++;
                        break;
                    }
                }
            }
            if (pangramFinder.ReadWords.get(i).length()-counter==0 && pangramFinder.ReadWords.get(i).length()>=4)  {

                GameWords.add(pangramFinder.ReadWords.get(i).toUpperCase(Locale.forLanguageTag("tr")));
            }
            counter=0;
        }

    }
}
