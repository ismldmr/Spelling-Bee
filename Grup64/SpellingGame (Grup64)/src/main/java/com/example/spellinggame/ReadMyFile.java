package com.example.spellinggame;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadMyFile {

    ArrayList<String> ReadWords;

    public void Read(){

        ReadWords=new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("src/main/resources/vpsozluk2.txt"), StandardCharsets.UTF_8);
            while (scanner.hasNextLine())
            {
                ReadWords.add(scanner.nextLine());
            }
            scanner.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
