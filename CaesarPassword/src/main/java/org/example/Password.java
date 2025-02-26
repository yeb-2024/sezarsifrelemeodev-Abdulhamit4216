package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.util.MissingResourceException;
import java.util.concurrent.LinkedBlockingDeque;

class Password implements ActionListener {
    JFrame frame;

    JLabel keyLabel;
    JTextField keyField;
    JLabel textLabel;
    JTextField textField;
    JButton encryptButton;
    JButton decryptButton;
    JLabel resultLabel;
    JLabel resultText;

    Password(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5,2));

        keyLabel = new JLabel("Anahtar:");
        keyField = new JTextField();
        textLabel = new JLabel("Metin:");
        textField = new JTextField();
        encryptButton = new JButton("Şifrele");
        decryptButton = new JButton("Çöz");
        resultLabel = new JLabel("Sonuç:");
        resultText = new JLabel("");

        resultLabel.add(resultText);

        encryptButton.addActionListener(this);
        encryptButton.setFocusable(false);
        decryptButton.addActionListener(this);
        decryptButton.setFocusable(false);

        frame.add(keyLabel);
        frame.add(keyField);
        frame.add(textLabel);
        frame.add(textField);
        frame.add(encryptButton);
        frame.add(decryptButton);
        frame.add(resultLabel);
        frame.pack();
        frame.setVisible(true);
    }

    public String shiftText(String text, int key){
        String alfabe = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String result = "";

        for (int i = 0; i < text.length(); i++){
            char getLetter = text.charAt(i);
            if (getLetter == ' '){
                result += " ";
                continue;
            }
            getLetter = Character.toUpperCase(getLetter);
            int index = alfabe.indexOf(getLetter);
            int newIndex = (index + key);
            result += alfabe.charAt(newIndex);
        }
        return result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == encryptButton){
            int key = Integer.parseInt(keyField.getText());
            String text = textField.getText();
            resultLabel.setText(shiftText(text, key));
        }

        if (e.getSource() == decryptButton){
            int key = Integer.parseInt(keyField.getText());
            String text = textField.getText();
            resultLabel.setText(shiftText(text, -key));
        }
        frame.setVisible(true);
    }
}
