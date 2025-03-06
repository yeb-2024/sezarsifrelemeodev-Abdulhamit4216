package org.example;

import javax.swing.*;

public class DecryptScreen {


    JFrame frame;
    JPanel panel;
    String SYMBOLS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String encrypt(String message ,int key){
        int mesajuzunluk = message.length();
        String sonuc = " " ;

        for (int i = 0; i <   mesajuzunluk; i++) {
            char harf = message.charAt(i);
            if (harf == ' '){
                sonuc+= " ";
                continue;
            }
            char buyukharf = Character.toUpperCase(harf);
            int index = SYMBOLS.indexOf(buyukharf);
            int yeniindex = (index + key) % SYMBOLS.length();
            char yeniharf = SYMBOLS.charAt(yeniindex);
            sonuc += yeniharf;
        }
        return sonuc;
    }

    public String decript(String şifre ,int key){
        int mesajUzunluk = şifre.length();
        String sonuc = " ";

        for (int i = 0; i < mesajUzunluk; i++) {
            char harf = şifre.charAt(i);
            if (harf == ' '){
                sonuc += " ";
                continue;
            }
            char buyukharf = Character.toUpperCase(harf);
            int index = SYMBOLS.indexOf(buyukharf);
            int yeniIndex = ((index - key) + SYMBOLS.length()) % SYMBOLS.length();
            char yeniharf = SYMBOLS.charAt(yeniIndex);
            sonuc += yeniharf;
        }

        return sonuc;
    }





}
