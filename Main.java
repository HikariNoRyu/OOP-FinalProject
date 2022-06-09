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
    JButton choiceButtonVortex;
    JButton choiceButtonTendo;
    JButton choiceButtonCharge;
    JButton choiceButtonGeo;
    JPanel playerPanel;
    JLabel hpLabel;
    JLabel hpLabelNumber;
    JLabel atkstatLabel;
    JLabel atkstatLabelNumber;
    String Pos;

    TitleScreenHandler TsHandler = new TitleScreenHandler();
    ChoiceHandler csHandler = new ChoiceHandler();

    ZhongLi Morax = new ZhongLi();

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
        startButton.setFocusPainted(false);
        startButtonPanel.add(startButton);

        con.add(startButtonPanel);
        con.add(titleNamePanel);

    }
    public void createGameScreen(){

        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(500,100,600,250);
        mainTextPanel.setBackground(Color.BLACK);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea("         Azhdaha Vs Zhong Li");
        mainTextArea.setFont(normalFont);
        mainTextArea.setBounds(600,100,600,250);
        mainTextArea.setBackground(Color.BLACK);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setLineWrap(true);

        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(350,920,800,250);
        choiceButtonPanel.setBackground(Color.black);
        con.add(choiceButtonPanel);

        choiceButtonVortex = new JButton("Vortex Vanquisher");
        choiceButtonVortex.setBackground(Color.black);
        choiceButtonVortex.setForeground(Color.white);
        choiceButtonVortex.setFont(normalFont);
        choiceButtonVortex.setFocusPainted(false);
        choiceButtonVortex.addActionListener(csHandler);
        choiceButtonVortex.setActionCommand("c1");
        choiceButtonPanel.add(choiceButtonVortex);

        choiceButtonTendo = new JButton("Tendo Bansho");
        choiceButtonTendo.setBackground(Color.black);
        choiceButtonTendo.setForeground(Color.white);
        choiceButtonTendo.setFont(normalFont);
        choiceButtonTendo.setFocusPainted(false);
        choiceButtonTendo.addActionListener(csHandler);
        choiceButtonTendo.setActionCommand("c2");
        choiceButtonPanel.add(choiceButtonTendo);

        choiceButtonCharge = new JButton("Spear Barage");
        choiceButtonCharge.setBackground(Color.black);
        choiceButtonCharge.setForeground(Color.white);
        choiceButtonCharge.setFont(normalFont);
        choiceButtonCharge.setFocusPainted(false);
        choiceButtonCharge.addActionListener(csHandler);
        choiceButtonCharge.setActionCommand("c3");
        choiceButtonPanel.add(choiceButtonCharge);

        choiceButtonGeo = new JButton("Channel Geo");
        choiceButtonGeo.setBackground(Color.black);
        choiceButtonGeo.setForeground(Color.white);
        choiceButtonGeo.setFont(normalFont);
        choiceButtonGeo.setFocusPainted(false);
        choiceButtonGeo.addActionListener(csHandler);
        choiceButtonGeo.setActionCommand("c4");
        choiceButtonPanel.add(choiceButtonGeo);

        playerPanel = new JPanel();
        playerPanel.setBounds(100,15,1000,50);
        playerPanel.setBackground(Color.BLACK);
        playerPanel.setLayout(new GridLayout(1,4));
        con.add(playerPanel);

        hpLabel = new JLabel("HP: ");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.WHITE);
        playerPanel.add(hpLabel);

        hpLabelNumber = new JLabel("52000");
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setBackground(Color.BLACK);
        hpLabelNumber.setForeground(Color.WHITE);
        playerPanel.add(hpLabelNumber);

        atkstatLabel = new JLabel("           ATK:");
        atkstatLabel.setFont(normalFont);
        atkstatLabel.setBackground(Color.BLACK);
        atkstatLabel.setForeground(Color.WHITE);
        playerPanel.add(atkstatLabel);

        atkstatLabelNumber = new JLabel("    900");
        atkstatLabelNumber.setFont(normalFont);
        atkstatLabelNumber.setBackground(Color.BLACK);
        atkstatLabelNumber.setForeground(Color.WHITE);
        playerPanel.add(atkstatLabelNumber);

        playerSetup();
    }
    public void playerSetup(){
        BeneathTheDragonQueller();
    }

    public void BeneathTheDragonQueller(){
        Pos = "Beneath The Dragon-Queller";
        mainTextArea.setText("You are Beneath The Dragon-Queller");
        choiceButtonVortex.setVisible(true);
        choiceButtonTendo.setVisible(true);
        choiceButtonCharge.setVisible(true);
        choiceButtonGeo.setVisible(true);

        choiceButtonVortex.setText("Talk to Azhdaha");
        choiceButtonTendo.setText("Challenge Azhdaha");
        choiceButtonCharge.setText("Leave");
        choiceButtonGeo.setText("QuitGame");


    }
    public void AzhdahaTalk(){
        Pos = "Azhdaha Attempts to break the seal";
        mainTextArea.setText("");
        choiceButtonVortex.setText("What have become of you?");
        choiceButtonTendo.setText("Azhdaha calm down");
        choiceButtonCharge.setText("Do you remember");
        choiceButtonGeo.setVisible(false);
    }
    public void AzhdahaBattle(){
        Pos = "Azhdaha Breaks The Seal";
        mainTextArea.setText( "                 Azhdaha roars \n             \"It is time Morax... \n            We settle this now!");
        choiceButtonVortex.setText("Vortex Vanquisher");
        choiceButtonTendo.setText("Tendo Bansho");
        choiceButtonCharge.setText("Spear Barrage");
        choiceButtonGeo.setText("Geo Explosion");
    }
    public void AzhdahaLeave(){
        Pos = "You cant";
        mainTextArea.setText("You cant run... Unless you close the game");
        choiceButtonVortex.setText("Face Azhdaha");
        choiceButtonTendo.setVisible(false);
        choiceButtonCharge.setVisible(false);
        choiceButtonGeo.setVisible(false);
    }
    public void ChangeMainTextArea(){
        mainTextArea.setText(Morax.Happen);
    }
    public class TitleScreenHandler implements ActionListener{

        public void actionPerformed(ActionEvent event) {
            createGameScreen();
        }
    }
    public class ChoiceHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){

            String yourChoice = event.getActionCommand();

            switch(Pos){
                case "Beneath The Dragon-Queller":
                    switch(yourChoice){
                        case"c1": AzhdahaTalk(); break;
                        case"c2": AzhdahaBattle(); break;
                        case"c3": AzhdahaLeave(); break;

                    }
                    break;
                case "You cant":
                    switch(yourChoice){
                        case "c1": BeneathTheDragonQueller();
                    }
                case "Azhdaha Breaks The Seal":
                    switch(yourChoice){
                        case"c1": Morax.VortexVanquisher();ChangeMainTextArea(); break;
                        case"c2": Morax.TendoBansho();ChangeMainTextArea();break;
                        case"c3": Morax.SpearBarage();ChangeMainTextArea();break;
                        case"c4": Morax.Geo();ChangeMainTextArea();break;
                    }
            }
        }

    }
}

