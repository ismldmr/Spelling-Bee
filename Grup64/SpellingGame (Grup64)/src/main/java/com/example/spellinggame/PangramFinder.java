package com.example.spellinggame;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class PangramFinder extends ReadMyFile{

    private ArrayList<String> Pangrams = new ArrayList<>();
    private ArrayList<Character> alphabet = new ArrayList<>();
    private ArrayList<String> PossibleWords = new ArrayList<>();
    private char[] converter;
    public String randomPangram;

    GameStarter gameStarter;

    public int RandGen(int bound)
    {
        return ThreadLocalRandom.current().nextInt(0,bound);
    }

    public void FindPangram () {

        Read();
        int counter =  0;
        for (int i = 0; i<ReadWords.size();i++)
        {
            if (ReadWords.get(i).length()>=7){
                PossibleWords.add(ReadWords.get(i));
            }
        }

        for (int i=0;i< PossibleWords.size();i++)
        {

            alphabet.clear();
            converter =null;
            for (int f=0;f< PossibleWords.get(i).length();f++)
            {
                alphabet.add(PossibleWords.get(i).charAt(f));
            }
            for (int j=0;j< alphabet.size();j++)
            {
                for (int z=j+1;z< alphabet.size();z++)
                {
                    if (alphabet.get(j).equals(alphabet.get(z))) {
                        counter++;
                        break;
                    }

                }
            }
            if (alphabet.size()-counter==7) {

                converter = new char[alphabet.size()];
                for (int c = 0; c < alphabet.size(); c++)
                    converter[c] = alphabet.get(c);
                Pangrams.add(String.valueOf(converter));
            }
            counter=0;
        }

    }

    public void bind(){
        FindPangram();
        randomPangram=Pangrams.get(RandGen(Pangrams.size()));
    }

}

