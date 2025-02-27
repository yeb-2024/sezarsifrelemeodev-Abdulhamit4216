package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EncryptScreen implements ActionListener {

    JFrame frame;
    JTextField keyTexField;
    JTextField messageTextField;
    JButton şifreleButton;
    Font font;
    DecryptScreen decryptScreen;


    EncryptScreen(){
        frame = new JFrame("şifreleme yap");
        font = new Font("Arial",Font.PLAIN,24);
        keyTexField =textFieldOlustur();
        messageTextField =  textFieldOlustur();
        şifreleButton = buttonOlustur("şifrele");
        decryptScreen = new DecryptScreen();
    }
    public void basla(){
        JPanel ustpanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        ustpanel.add(new JLabel("Anahtar"));
        ustpanel.add(keyTexField);

        JPanel altpanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        altpanel.add(new JLabel("mesaj"));
        altpanel.add(messageTextField);

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
        String mesaj = messageTextField.getText().trim();
        String şifre = decryptScreen.encrypt(mesaj,Integer.parseInt(anahtar));
        System.out.println("Anahtar" + anahtar);
        System.out.println("mesaj " + mesaj);
        System.out.println("şifre" + şifre);
        JOptionPane.showMessageDialog(frame,"şifre" + şifre, "şifrelem sonucu ",JOptionPane.INFORMATION_MESSAGE);

    }
}
