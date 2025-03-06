package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DecryptEncryption implements ActionListener {

    JFrame frame;
    JTextField keyTexField;
    JTextField passTextField;
    JButton şifreleButton;
    Font font;
    DecryptScreen decryptScreen;

    DecryptEncryption(){
        frame = new JFrame("şifreleme çöz ");
        font = new Font("Arial",Font.PLAIN,24);
        keyTexField =textFieldOlustur();
        passTextField =  textFieldOlustur();
        şifreleButton = buttonOlustur("çöz");
        decryptScreen = new DecryptScreen();
    }
    public void basla(){
        JPanel ustpanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        ustpanel.add(new JLabel("Anahtar"));
        ustpanel.add(keyTexField);

        JPanel altpanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        altpanel.add(new JLabel("şifre"));
        altpanel.add(passTextField);

        frame.add(ustpanel);
        frame.add(altpanel);
        frame.add(şifreleButton);

        frame.setLayout(new GridLayout(3,1));
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public JButton buttonOlustur(String yazı){
        JButton button =new JButton(yazı);
        button.setFont(font);
        button.addActionListener(this);
        return button;

    }


    public JTextField textFieldOlustur(){
        JTextField textField = new JTextField();
        textField.setFont(font);
        textField.setPreferredSize(new Dimension(200,50));
        return textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String anahtar = keyTexField.getText().trim();
        String şifre = passTextField.getText().trim();
        String mesaj = decryptScreen.decript(şifre,Integer.parseInt(anahtar));
        System.out.println("Anahtar: " + anahtar);
        System.out.println("Mesaj: " + mesaj);
        System.out.println("Şifre: " + şifre);
        JOptionPane.showMessageDialog(frame,"şifre" + mesaj, "şifrelem sonucu ",JOptionPane.INFORMATION_MESSAGE);

    }
}
