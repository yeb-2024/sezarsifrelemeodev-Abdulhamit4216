package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaesarPassword implements ActionListener {
    JFrame frame;
    JPanel panel;
    JLabel label , label1 ;
    JTextField textField ,jTextField;
    JButton encryptButton, decryptButton;
    Font fant ;

    CaesarPassword() {

        frame = new JFrame("anasayfa");
        label = new JLabel("sezar sifrelem yontemi");
        fant = new Font("Arial",Font.PLAIN,24);
        encryptButton = buttonOlustur("şifrele");
        decryptButton = buttonOlustur("şifre çöz");
        panel = new JPanel();

    }
    public void basla(){
        frame.setLayout(new GridLayout(2,1));
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(label);

        panel.setLayout(new FlowLayout());
        panel.add(encryptButton);
        panel.add(decryptButton);

        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setFont(fant);

        frame.add(panel);
        frame.setVisible(true);
    }

    public JButton buttonOlustur(String yazı){
        JButton button =new JButton(yazı);
        button.setFont(fant);
        button.addActionListener(this);
        return button;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == encryptButton){
            EncryptScreen encryptScreen = new EncryptScreen();
            encryptScreen.basla();
            frame.dispose();
        }
        if (e.getSource() == decryptButton){
            DecryptEncryption decryptEncryption = new DecryptEncryption();
            decryptEncryption.basla();
            frame.dispose();
        }
    }


}
