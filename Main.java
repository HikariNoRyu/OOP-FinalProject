//Set package for the program
package com.company;

//Import Java libraries for use
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import java.util.Objects;
import java.util.spi.ResourceBundleControlProvider;
import javax.sound.sampled.Control;
import javax.sound.sampled.FloatControl;
import javax.swing.*;


public class Main {
    //Create a container named con
    Container con;
    //Create the main window of the game using the JFrame module
    JFrame window = new JFrame();
    //Create Tittle Name Panel to store the game tittle. Create tittle label to display the game tittle.
    JPanel titleNamePanel;
    JLabel titleNameLabel;
    //Create Game tittle font and normal font to regulate size in the game.
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 40);
    //Create a panel to store the start button.
    JPanel startButtonPanel;
    //Create a button that will be used to start the game
    JButton startButton;
    //Create a mainTextAre where most of the game narative is happening
    JTextArea mainTextArea;
    //Create The Panel for the main text
    JPanel mainTextPanel;
    //Create the choiceButtonPanels
    JPanel choiceButtonPanel;
    //All of the choice buttons in the game.
    JButton choiceButtonVortex;
    JButton choiceButtonTendo;
    JButton choiceButtonCharge;
    JButton choiceButtonGeo;
    //Make a panel for the player details
    JPanel playerPanel;
    //Label for Hp
    JLabel hpLabel;
    //Label for HP value
    JLabel hpLabelNumber;
    //Label for ATK
    JLabel atkstatLabel;
    //Label for ATK Value
    JLabel atkstatLabelNumber;
    //Position in the game
    String Pos;
    //Initialize the BGM Sound effect
    SE RageBeneath = new SE();
    //Initialize Meatball Sound effect
    SE Meatball = new SE();
    //Create a label called display field where Image of Azhdaha is stored.
    JLabel displayField;
    //Create Handlers for the button to Take in action and execute.
    TitleScreenHandler TsHandler = new TitleScreenHandler();
    ChoiceHandler csHandler = new ChoiceHandler();
    AudioHandler AHandler = new AudioHandler();
    AudioHandlerAzhdaha AudioAZ = new AudioHandlerAzhdaha();
    //Create a label for Tendo Banso image (currently not being used)
    JLabel TendoField;
    //Initialize character Morax with ZhongLi class
    ZhongLi Morax = new ZhongLi();
    //Initialize Azhdaha character with GeoDragon Class
    GeoDragon Azhdaha = new GeoDragon();
    //String of Tendo Bansho sound effect
    String Tendo = "Images/TendoBansho.wav";
    //String of the path to the sound
    String Rage = "Images/Rage.wav";

    //Main function
    public static void main(String[] args) {

        new Main();
    }
    // Main Function
    public Main(){
        //Creating the window and seeting the dimensions
        window.setSize(1600, 1200);
        //Create a default close operation to makesure the window closes properly
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Make the Window non resizeable therefore user cannot change the window and ruin the game UI scaling that is poorly optimized
        window.setResizable(false);
        //Set window tittle to the game title
        window.setTitle("Pokeshin Impact");
        //Set the layout of the window to null
        window.setLayout(null);
        //Set the window general background to black as it is the stereo typical Text rpg background
        window.getContentPane().setBackground(Color.black);
        //Make window have no location relativity.
        window.setLocationRelativeTo(null);
        //Make the window Visible
        window.setVisible(true);
        con = window.getContentPane();

        //Create a panel for the game tittle
        titleNamePanel = new JPanel();
        //Set the panel background to black to match with the window background making it seem invisible
        titleNamePanel.setBackground(Color.black);
        //Set the bounds of the panel so it doesn't go to the wrong space
        titleNamePanel.setBounds(200, 200, 1200, 300);
        //Create the name label of the game
        titleNameLabel = new JLabel("Pokeshin Impact");
        //Set the foreground of the label color to white so that the text is visible in the black background.
        titleNameLabel.setForeground(Color.white);
        //Set font to the tittleFont
        titleNameLabel.setFont(titleFont);
        //Add the label into the panel
        titleNamePanel.add(titleNameLabel);

        //Create the start button pannel to store the button that will start the game
        startButtonPanel = new JPanel();
        //Set the button panel bounds and size therefore it is in a good position and in a good size
        startButtonPanel.setBounds(655, 600, 300, 200);
        //Set the background black to make the panel seem invisible
        startButtonPanel.setBackground(Color.BLACK);
        //Create the button with the text START that will start the game
        startButton = new JButton("START");
        //Set the size of the button so it is not tiny
        startButton.setSize(200, 100);
        //Set the background and foreground colors to make the button more attractive
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        //Set the font that will be used by the start button
        startButton.setFont(normalFont);
        //Add a handler so the button can run actions upon click.
        startButton.addActionListener(TsHandler);
        //Add a handler for the BGM
        startButton.addActionListener(AudioAZ);
        //Take away focus paint as it looks horrid
        startButton.setFocusPainted(false);
        //Add start button to the panel, so it doesn't drift off to narnia
        startButtonPanel.add(startButton);
        //Add all the panels into the container con that was created
        con.add(startButtonPanel);
        con.add(titleNamePanel);

    }
    // game creation function
    public void createGameScreen(){
        //Make the tittle disappear, so we can get into the game without the tittle staying on forever
        titleNamePanel.setVisible(false);
        //Make the start button disappear as the game have already started.
        startButtonPanel.setVisible(false);
        //Initialize the main text panel as a JPanel
        mainTextPanel = new JPanel();
        //Set the bounds for the main text panel
        mainTextPanel.setBounds(500,100,600,250);
        //Set the background to black
        mainTextPanel.setBackground(Color.BLACK);
        //Add it to the container
        con.add(mainTextPanel);
        //Make the main text area wit hthe text "AZHDAHA VS ZHONG LI"
        mainTextArea = new JTextArea("         AZHDAHA VS ZHONG LI");
        //Set the font to the normal font so the game looks structured and uniform on the fonts
        mainTextArea.setFont(normalFont);
        //Create the text area bounds and make it a little bigger as it is where all the text is going to be displayed
        mainTextArea.setBounds(600,100,600,250);
        //Set background to black to make it seem invisible
        mainTextArea.setBackground(Color.BLACK);
        //Set Foreground to white to make text visible
        mainTextArea.setForeground(Color.white);
        //Use setLineWrap to make sure the lines are warpped when they are too long
        mainTextArea.setLineWrap(true);
        //Add the mainText to the Panel
        mainTextPanel.add(mainTextArea);

        //Make the panel for one of the most important parts of the game, which is the choice buttons
        choiceButtonPanel = new JPanel();
        //Set the panel bounds
        choiceButtonPanel.setBounds(350,920,800,250);
        //Set the background color to black to make it seem invisible
        choiceButtonPanel.setBackground(Color.black);
        //Add the panel into the container
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
    public void ImageLoadAzhdaha(){
        ImageIcon AzhSprite = new ImageIcon(Objects.requireNonNull(getClass().getResource("Images/Azhdaha.png")));
        displayField = new JLabel(AzhSprite);
        con.add(displayField);
        displayField.setBounds(300, 175, 1000, 1000);
    }
    public void ImgTendoBansho(){
        ImageIcon ZhongSprite = new ImageIcon(Objects.requireNonNull(getClass().getResource("Images/Iwillhaveorder.png")));
        TendoField = new JLabel(ZhongSprite);
        con.add(TendoField);
        TendoField.setBounds(300, 175, 700, 600);
    }
    public void playerSetup(){
        BeneathTheDragonQueller();
    }

    public void BeneathTheDragonQueller(){
        ImageLoadAzhdaha();
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
        ImageLoadAzhdaha();
        Pos = "Azhdaha Attempts to break the seal";
        mainTextArea.setText("");
        choiceButtonVortex.setText("What have become of you?");
        choiceButtonTendo.setText("Azhdaha calm down");
        choiceButtonCharge.setText("Do you remember");
        choiceButtonGeo.setVisible(false);
    }
    public void AzhdahaBattle(){
        ImageLoadAzhdaha();
        Pos = "Azhdaha Breaks The Seal";
        mainTextArea.setText( "                 Azhdaha roars \n             \"It is time Morax... \n            We settle this now! \n        AzhdahaHP: " + Azhdaha.GeoDragonHp + " HP");
        choiceButtonVortex.setText("Vortex Vanquisher");
        choiceButtonTendo.setText("Tendo Bansho");
        choiceButtonTendo.addActionListener(AHandler);
        choiceButtonCharge.setText("Spear Barrage");
        choiceButtonGeo.setText("Geo Explosion");
        choiceButtonTendo.setVisible(true);
        choiceButtonCharge.setVisible(true);
        choiceButtonGeo.setVisible(true);

        Azhdaha.GeoDragonHp = Azhdaha.GeoDragonHp - Morax.dmg;
    }
    public void AzhdahaAttack(){

        Pos = "AzhdahaAttacks";

        ImageLoadAzhdaha();
        choiceButtonVortex.setText("Continue");
        choiceButtonTendo.setVisible(false);
        choiceButtonCharge.setVisible(false);
        choiceButtonGeo.setVisible(false);

        mainTextArea.setText("Azhdaha Attacks You and dealt " + Azhdaha.GeoDragonDmg + " Damage ");

        Morax.hp = Morax.hp - Azhdaha.GeoDragonDmg;

        hpLabelNumber.setText(""+ Morax.hp);


    }
    public void Resetdmg(){
        Morax.dmg = 0;
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
        mainTextArea.setText(Morax.Happen + " \n  It Dealt " + Morax.dmg);

    }
    public void ContButton(){
        Pos = "attacked";
        choiceButtonVortex.setText("Continue");
        choiceButtonTendo.setVisible(false);
        choiceButtonCharge.setVisible(false);
        choiceButtonGeo.setVisible(false);
        Azhdaha.GeoDragonHp = Azhdaha.GeoDragonHp - Morax.dmg;
        Resetdmg();
    }
    public void win(){
        Pos = "win";

        mainTextArea.setText("You defeated Azhdaha!");
        choiceButtonVortex.setText("Retry");
        choiceButtonTendo.setText("Quit Game");
        choiceButtonTendo.setVisible(true);
        choiceButtonCharge.setVisible(false);
        choiceButtonGeo.setVisible(false);

    }
    public void Retry(){
        Azhdaha.GeoDragonHp = 1000000;
        Morax.hp = 52000;
        BeneathTheDragonQueller();
    }
    public void CloseGame(){
        window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
    }
    public class AudioHandlerAzhdaha implements ActionListener{
        public void actionPerformed(ActionEvent event) {

            RageBeneath.setFile(Rage);
            FloatControl gainControl =
                    (FloatControl) RageBeneath.clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-20.0f); // Reduce volume by 10db
            RageBeneath.play(Rage);

            RageBeneath.loop(Rage);
        }
    }
    public class AudioHandler implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            Meatball.setFile(Tendo);
            Meatball.play(Tendo);
        }
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
                case "Azhdaha Attempts to break the seal":
                    switch (yourChoice){
                        case"c1": AzhdahaBattle();
                        case"c2": AzhdahaBattle();
                        case"c3": AzhdahaBattle();
                    }
                case "Azhdaha Breaks The Seal":
                    switch(yourChoice){
                        case"c1": Morax.VortexVanquisher();ChangeMainTextArea();ContButton();break;
                        case"c2": Morax.TendoBansho();ChangeMainTextArea();ContButton();break;
                        case"c3": Morax.SpearBarage();ChangeMainTextArea();ContButton();break;
                        case"c4": Morax.Geo();ChangeMainTextArea();ContButton();break;
                    }
                case "attacked":
                    switch (yourChoice){
                        case"c1": if (Azhdaha.GeoDragonHp < 1){
                            win();
                        }
                        else {
                            AzhdahaAttack();
                        }
                        break;
                    }
                    break;
                case "AzhdahaAttacks":
                    switch (yourChoice) {
                        case"c1":
                            if (Morax.hp < 1){

                            }
                            else{
                                AzhdahaBattle();
                            }
                            break;
                    }
                    break;
                case "win":
                    switch (yourChoice){
                        case"c1": Retry();break;
                        case"c2": CloseGame();break;
                    }
            }
        }

    }
}

