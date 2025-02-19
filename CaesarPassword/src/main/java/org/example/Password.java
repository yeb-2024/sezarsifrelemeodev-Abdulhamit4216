package org.example;

import javax.swing.*;
import java.awt.*;

public class Password {
    JFrame frame;

    JLabel keyLabel;

    Password(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5,2));

        keyLabel = new JLabel("Anahtar: ");
        JTextField keyField = new JTextField();


    }
}
