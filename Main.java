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
    //All the choice buttons in the game.
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
        titleNamePanel.setBounds(200, 200, 1200, 500);
        //Create the name label of the game
        titleNameLabel = new JLabel("Pokeshin Impact");
        //Set the foreground of the label color to white so that the text is visible in the black background.
        titleNameLabel.setForeground(Color.white);
        //Set font to the tittleFont
        titleNameLabel.setFont(titleFont);
        //Add the label into the panel
        titleNamePanel.add(titleNameLabel);

        //Create the start button panel to store the button that will start the game
        startButtonPanel = new JPanel();
        //Set the button panel bounds and size therefore it is in a good position and in a good size
        startButtonPanel.setBounds(655, 600, 300, 100);
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
        //Use setLineWrap to make sure the lines are wrapped when they are too long
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

        //Create the first choice button
        choiceButtonVortex = new JButton("Vortex Vanquisher");
        //Set the background of the button to black
        choiceButtonVortex.setBackground(Color.black);
        //Set the foreground of the button to white
        choiceButtonVortex.setForeground(Color.white);
        //Set the font to the regulated normal font
        choiceButtonVortex.setFont(normalFont);
        //Make it not look Horrid
        choiceButtonVortex.setFocusPainted(false);
        //Add a choice handler.
        choiceButtonVortex.addActionListener(csHandler);
        //Set action key command to c1
        choiceButtonVortex.setActionCommand("c1");
        //Add the button into the panel
        choiceButtonPanel.add(choiceButtonVortex);

        //Create the second choice button
        choiceButtonTendo = new JButton("Tendo Bansho");
        //Set the background for the button to black
        choiceButtonTendo.setBackground(Color.black);
        //Give it a white foreground so the button is not invisible
        choiceButtonTendo.setForeground(Color.white);
        //Set the button font to the normal font
        choiceButtonTendo.setFont(normalFont);
        //Set focus painted to false
        choiceButtonTendo.setFocusPainted(false);
        //Add the choice handler function into the buttons
        choiceButtonTendo.addActionListener(csHandler);
        //Set the action command key to c2 for choice 2
        choiceButtonTendo.setActionCommand("c2");
        //Add it to the button panels
        choiceButtonPanel.add(choiceButtonTendo);

        //Create the third choice button
        choiceButtonCharge = new JButton("Spear Barage");
        //Set the background of the button to black
        choiceButtonCharge.setBackground(Color.black);
        //Set the foreground of the button to white
        choiceButtonCharge.setForeground(Color.white);
        //Set the font of the button to the normal font
        choiceButtonCharge.setFont(normalFont);
        //Set focus painted to false
        choiceButtonCharge.setFocusPainted(false);
        //Give the button the handler function
        choiceButtonCharge.addActionListener(csHandler);
        //Give the button action key command c3
        choiceButtonCharge.setActionCommand("c3");
        //Add the button to the panel
        choiceButtonPanel.add(choiceButtonCharge);

        //Create the last button name geo
        choiceButtonGeo = new JButton("Channel Geo");
        //Set the background of the button to black
        choiceButtonGeo.setBackground(Color.black);
        //Set the foreground of the button to white
        choiceButtonGeo.setForeground(Color.white);
        //Make the button use normalFont
        choiceButtonGeo.setFont(normalFont);
        //Set focus painted as false
        choiceButtonGeo.setFocusPainted(false);
        //Make the button take it csHandler which is the choice handler for all the buttons
        choiceButtonGeo.addActionListener(csHandler);
        //Set the command key to c4
        choiceButtonGeo.setActionCommand("c4");
        //Add the button to the panel
        choiceButtonPanel.add(choiceButtonGeo);

        //Create a panel for the player
        playerPanel = new JPanel();
        //Set the bounds of the panel which will be low on height but enough for the whole screen in width
        playerPanel.setBounds(100,15,1000,50);
        //Set the background of the panel to black so, it will seem invisible
        playerPanel.setBackground(Color.BLACK);
        //Set the layout of the panel to have grids in 1 row and 4 cols
        playerPanel.setLayout(new GridLayout(1,4));
        //Add the panel into the container
        con.add(playerPanel);

        //Create A label for the "HP: " text that will display the user hp
        hpLabel = new JLabel("HP: ");
        //Set the font to normal font
        hpLabel.setFont(normalFont);
        //Set the foreground to white
        hpLabel.setForeground(Color.WHITE);
        //Add the Hp label into the player panel
        playerPanel.add(hpLabel);

        //Create new label called Hp label number which displays the Hp of the player
        hpLabelNumber = new JLabel("52000");
        //Set font to normalFont
        hpLabelNumber.setFont(normalFont);
        //Set label background to black
        hpLabelNumber.setBackground(Color.BLACK);
        //Set label foreground to white
        hpLabelNumber.setForeground(Color.WHITE);
        //Add the hp number label into the playerPanel
        playerPanel.add(hpLabelNumber);

        //Make a label for the default attack stat
        atkstatLabel = new JLabel("           ATK:");
        //Set the font to normalFont
        atkstatLabel.setFont(normalFont);
        //Set the background to black
        atkstatLabel.setBackground(Color.BLACK);
        //Set the foreground to white
        atkstatLabel.setForeground(Color.WHITE);
        //Add the labels to the panel
        playerPanel.add(atkstatLabel);

        //Add a label for the atk stat numbers
        atkstatLabelNumber = new JLabel("    900");
        //Set the font to normal font
        atkstatLabelNumber.setFont(normalFont);
        //Set the background to black
        atkstatLabelNumber.setBackground(Color.BLACK);
        //Set the foreground to white
        atkstatLabelNumber.setForeground(Color.WHITE);
        //Add the label into the playerPanel
        playerPanel.add(atkstatLabelNumber);
        //Run the playerSetup(); function
        playerSetup();
    }
    //Create a function to import image
    public void ImageLoadAzhdaha(){
        //Create a new variable AzhSprite using the imported class ImageICon and use the getClass and getResource methods to import image of Azhdaha that is in the resource folder
        ImageIcon AzhSprite = new ImageIcon(Objects.requireNonNull(getClass().getResource("Images/Azhdaha.png")));
        //Create a new JLabel called displayField to put Azhdaha's Sprite in
        displayField = new JLabel(AzhSprite);
        //Dump it in the container
        con.add(displayField);
        //Set the bounds to make sure the size is not too big or too small
        displayField.setBounds(300, 175, 1000, 1000);
    }

    //Function to run the main game scenario
    public void playerSetup(){
        BeneathTheDragonQueller();
    }

    //Main game scenario function
    public void BeneathTheDragonQueller(){
        //Load the Azhdaha sprite
        ImageLoadAzhdaha();
        //Set the string position of the game as "Beneath The Dragon-Queller"
        Pos = "Beneath The Dragon-Queller";
        //Change the Text in mainTextArea to "You are Beneath The Dragon-Queller"
        mainTextArea.setText("You are Beneath The Dragon-Queller");
        //Make all the buttons visible
        choiceButtonVortex.setVisible(true);
        choiceButtonTendo.setVisible(true);
        choiceButtonCharge.setVisible(true);
        choiceButtonGeo.setVisible(true);

        //Set button texts using the setText method
        choiceButtonVortex.setText("Talk to Azhdaha");
        choiceButtonTendo.setText("Challenge Azhdaha");
        choiceButtonCharge.setText("Leave");
        choiceButtonGeo.setText("QuitGame");
    }
    //Create a function for attempting to talk to Azhdaha
    public void AzhdahaTalk(){
        //Load the Azhdaha image once more
        ImageLoadAzhdaha();
        //Set the position for the function
        Pos = "Azhdaha Attempts to break the seal";
        //Set the main text area to nothing
        mainTextArea.setText("");
        //Set text buttons
        choiceButtonVortex.setText("What have become of you?");
        choiceButtonTendo.setText("Azhdaha calm down");
        choiceButtonCharge.setText("Do you remember");
        //Remove the last button because I could'nt think of anything to put there
        choiceButtonGeo.setVisible(false);
    }
    //The battle
    public void AzhdahaBattle(){
        //Load the image
        ImageLoadAzhdaha();
        //Set the position of the function
        Pos = "Azhdaha Breaks The Seal";
        //Set the main text area text with horrible formatting
        mainTextArea.setText( "                 Azhdaha roars \n             " +
                "\"It is time Morax... \n            " +
                "We settle this now! \" \n        " +
                "AzhdahaHP: " + Azhdaha.GeoDragonHp + " HP");
        //Set button texts
        choiceButtonVortex.setText("Vortex Vanquisher");
        choiceButtonTendo.setText("Tendo Bansho");
        //Add the audio of the tendo bansho button
        choiceButtonTendo.addActionListener(AHandler);
        //Change button texts
        choiceButtonCharge.setText("Spear Barrage");
        choiceButtonGeo.setText("Geo Explosion");
        //Make all buttons visible
        choiceButtonTendo.setVisible(true);
        choiceButtonCharge.setVisible(true);
        choiceButtonGeo.setVisible(true);
        //Take away Azhdaha's hp everytime he got smacked
        Azhdaha.GeoDragonHp = Azhdaha.GeoDragonHp - Morax.dmg;
    }
    //Make a function where Azhdaha attacks the player
    public void AzhdahaAttack(){

        //Set the position of the function
        Pos = "AzhdahaAttacks";
        //Load the Azhdaha image
        ImageLoadAzhdaha();
        //Set the text button to continue
        choiceButtonVortex.setText("Continue");
        //Set the other buttons to invisible
        choiceButtonTendo.setVisible(false);
        choiceButtonCharge.setVisible(false);
        choiceButtonGeo.setVisible(false);
        //Set the main text are text
        mainTextArea.setText("Azhdaha Attacks You and dealt " + Azhdaha.GeoDragonDmg + " Damage ");
        //Make Morax hp reduce
        Morax.hp = Morax.hp - Azhdaha.GeoDragonDmg;
        //Set the hp label number
        hpLabelNumber.setText(""+ Morax.hp);
    }
    //Reset function for the damage so it doesn't stack
    public void Resetdmg(){
        Morax.dmg = 0;
    }
    //Create a Leave function for Azhdaha
    public void AzhdahaLeave(){
        //Set the position for the function
        Pos = "You cant";
        // Change Text of the main text
        mainTextArea.setText("You cant run... Unless you close the game");
        //Change the text of the button
        choiceButtonVortex.setText("Face Azhdaha");
        choiceButtonTendo.setVisible(false);
        choiceButtonCharge.setVisible(false);
        choiceButtonGeo.setVisible(false);
    }
    //Change the main text to what it happened in the ZhongLi class
    public void ChangeMainTextArea(){
        mainTextArea.setText(Morax.Happen + " \n  It Dealt " + Morax.dmg);

    }
    //Create a function to continue
    public void ContButton(){
        //Set the position to attacked
        Pos = "attacked";
        //Set the button text to Continue
        choiceButtonVortex.setText("Continue");
        //Make the other buttons dissapear
        choiceButtonTendo.setVisible(false);
        choiceButtonCharge.setVisible(false);
        choiceButtonGeo.setVisible(false);
        //Set the geo dragon hp
        Azhdaha.GeoDragonHp = Azhdaha.GeoDragonHp - Morax.dmg;
        //Reset the damage for Morax so it doesn't stack
        Resetdmg();
        Gacha();
    }
    //Create a function win(); for game win scenario
    public void win(){
        //Set the position to win
        Pos = "win";
        //Run Begone
        Begone();
        //Change the text to defeated Azhdaha
        mainTextArea.setText("You defeated Azhdaha!");
        //Change the button texts to Retry or quit the game
        choiceButtonVortex.setText("Retry");
        choiceButtonTendo.setText("Quit Game");
        //Remove the AudioHandler so Tendo Bansho sound effect doesn't play on click
        choiceButtonTendo.removeActionListener(AHandler);
        //Set the tendo button to visible
        choiceButtonTendo.setVisible(true);
        //Set the other buttons to false
        choiceButtonCharge.setVisible(false);
        choiceButtonGeo.setVisible(false);

    }
    //Create a function to make display field disappear
    public void Begone(){
        displayField.setVisible(false);
    }
    //Create Lose Function for los scenario
    public void Lose(){
        //Set the position
        Pos = "Los";
        Begone();
        //Change the text area text to Azhdaha kicked your ass
        mainTextArea.setText("     Azhdaha kicked your ass");
        //Change the buttons to retry and quit game
        choiceButtonVortex.setText("Retry");
        choiceButtonTendo.setText("Quit Game");
        //Remove the audio handler so that the button doesn't play "Tendo Banso" audio file
        choiceButtonTendo.removeActionListener(AHandler);
        //Set the second button to visible
        choiceButtonTendo.setVisible(true);
        //Make the other buttons go poof
        choiceButtonCharge.setVisible(false);
        choiceButtonGeo.setVisible(false);
    }
    //Retry function to reset the HP values of both the player and the enemies
    public void Retry(){
        Azhdaha.GeoDragonHp = 1000000;
        Morax.hp = 52000;
        //Rerun the BeneatTheDragonQueller Function
        BeneathTheDragonQueller();
    }
    public void Gacha(){
        Azhdaha.GeoDragonDmg = new java.util.Random().nextInt(9000);
        Morax.crit = new java.util.Random().nextInt(100);
    }
    // Create a function to close the game using windowEvent imported class
    public void CloseGame(){
        choiceButtonTendo.removeActionListener(AHandler);
        window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
    }
    //Create AudioHandler class that implements the ActionListener Class
    public class AudioHandlerAzhdaha implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            //Set the file of RageBeneath to audio string Rage
            RageBeneath.setFile(Rage);
            //Gain control of the audio to change the audio levels
            FloatControl gainControl =
                    (FloatControl) RageBeneath.clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-20.0f); // Reduce volume by 10db
            //Play the main bgm
            RageBeneath.play(Rage);
            //Make the music loop
            RageBeneath.loop(Rage);
        }
    }
    //Create class Audio handler for playing the tendo bansho audio
    public class AudioHandler implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            //Set the audio file
            Meatball.setFile(Tendo);
            //Play the audio file
            Meatball.play(Tendo);
        }
    }
    //Create class TittleScreenHandler
    public class TitleScreenHandler implements ActionListener{

        public void actionPerformed(ActionEvent event) {
            //Run the game  createGameScreen(); function
            createGameScreen();
        }
    }
    //Create a choiceHandler for the multiple buttons and multiple scenarios
    public class ChoiceHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){

            //Make string yourChoice and get the action command
            String yourChoice = event.getActionCommand();
            //Use switch to run each scenario
            switch(Pos){
                //If Pos is "Beneath The Dragon-Queller" execute swtch for yourChoice
                case "Beneath The Dragon-Queller":
                    switch(yourChoice){
                        //First button runs the AzhdagaTalk function
                        case"c1": AzhdahaTalk(); break;
                        //Second button runs the Battle function
                        case"c2": AzhdahaBattle(); break;
                        //Set the third button to do the Leave function
                        case"c3": AzhdahaLeave(); break;
                    }
                    //Make sure to break the loop
                    break;
                //After Trying to leave Azhdaha go back to DragonQueller
                case "You cant":
                    //Same switch for each choice scenario
                    switch(yourChoice){
                        //Only one case to go back to the Queller
                        case "c1": BeneathTheDragonQueller();
                    }
                    //If Azhdaha attempts t obreak the seal is the position
                case "Azhdaha Attempts to break the seal":
                    //Go to choice options
                    switch (yourChoice){
                        //All of them goes back to the battle because no running from Azhdaha
                        case"c1": AzhdahaBattle();
                        case"c2": AzhdahaBattle();
                        case"c3": AzhdahaBattle();
                    }
                    //Azhdaha Battle Phase
                case "Azhdaha Breaks The Seal":
                    //Choices switch again
                    switch(yourChoice){
                        //Run a crap ton of functions for each button making sure the scenario runs well
                        case"c1": Morax.VortexVanquisher();ChangeMainTextArea();ContButton();break;
                        case"c2": Morax.TendoBansho();ChangeMainTextArea();ContButton();break;
                        case"c3": Morax.SpearBarage();ChangeMainTextArea();ContButton();break;
                        case"c4": Morax.Geo();ChangeMainTextArea();ContButton();break;
                    }
                    //Case attacked is when Azhdaha is attacked
                case "attacked":
                    //Make the choice switch once more
                    switch (yourChoice){
                        //Make the first choice go onto win scenario if the health of Azhdaha is less than 1
                        case"c1": if (Azhdaha.GeoDragonHp < 1){
                            win();
                        }
                        //If not continue to the attacking phase
                        else {
                            AzhdahaAttack();
                        }
                        //break loop
                        break;
                    }
                    //and break loop
                    break;
                    //When azhdaha attacks
                case "AzhdahaAttacks":
                    switch (yourChoice) {
                        //Contunue to a loss when Morax hp is less than one meaning player lost
                        case"c1":
                            if (Morax.hp < 1){
                                Lose();
                            }
                            //else go back to fighting
                            else{
                                AzhdahaBattle();
                            }
                            //break the loop
                            break;
                    }
                    //break the loop
                    break;
                    //When win
                case "win":
                    //One button leads to retrying the game and the other closes the game
                    switch (yourChoice){
                        case"c1": Retry();break;
                        case"c2": CloseGame();break;
                    }
                    //Pretty much the same things as win but on a losing scenario this time
                case "Los":
                    switch(yourChoice){
                        case"c1": Retry();break;
                        case"c2": CloseGame();break;
                    }
            }
        }

    }
}

