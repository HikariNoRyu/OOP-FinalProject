package com.company;

import java.awt.*;
import javax.swing.*;

public class ImageImport extends JFrame {
    private ImageIcon Img1;
    private JLabel label1;
    private ImageIcon img2;
    private JLabel label2;

    ImageImport() {
        setLayout(new FlowLayout());

        Img1 = new ImageIcon(getClass().getResource("Resources/Sprites/Azhdaha.png"));
        label1 = new JLabel(Img1);
    }
}