package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Main {

    Container con;
    JFrame window = new JFrame();
    JPanel titleNamePanel;
    JLabel titleNameLabel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 40);
    JPanel startButtonPanel;
    JButton startButton;
    JTextArea mainTextArea;
    JPanel mainTextPanel;
    JPanel choiceButtonPanel;

    TitleScreenHandler TsHandler = new TitleScreenHandler();

    public static void main(String[] args) {
        new Main();
    }

    public Main(){

        window.setSize(1600, 1200);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Pokeshin Impact");
        window.setLayout(null);
        window.getContentPane().setBackground(Color.black);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        con = window.getContentPane();


        titleNamePanel = new JPanel();
        titleNamePanel.setBackground(Color.black);
        titleNamePanel.setBounds(200, 200, 1200, 300);
        titleNameLabel = new JLabel("Pokeshin Impact");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);


        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(655, 600, 300, 200);
        startButtonPanel.setBackground(Color.BLACK);

        startButton = new JButton("START");
        startButton.setSize(200, 100);
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        startButton.setFont(normalFont);
        startButton.addActionListener(TsHandler);

        startButtonPanel.add(startButton);

        con.add(startButtonPanel);
        con.add(titleNamePanel);

    }
    public void createGameScreen(){

        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(500,100,600,250);
        mainTextPanel.setBackground(Color.blue);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea("Azhdaha Vs Zhong Li");
        mainTextArea.setFont(normalFont);
        mainTextArea.setBounds(500,100,600,250);
        mainTextArea.setBackground(Color.blue);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setLineWrap(true);

        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(500,350,300,150);
        choiceButtonPanel.setBackground(Color.blue);
        con.add(choiceButtonPanel);
    }
    public class TitleScreenHandler implements ActionListener{

        public void actionPerformed(ActionEvent event) {
            createGameScreen();
        }
    }
}
