package com.company;

import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;

public class Panel extends JPanel implements Runnable {

    //Screen settings
    //Set original tile size as 16 pixels
    final int originalTileSize = 16;

    //Set Scaling for tile size
    final int scale = 3;

    //Declare int variable tile size making each tiles 48 x 48 pixels
    final int tileSize = originalTileSize*scale;

    //Set maxScreenCol and maxScreenRows
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;

    //Set the official width and height of the screen
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    Thread gameThread;

    //Panel settingss
    public Panel(){
        this.setPreferredSize(new Dimension());
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        while (gameThread != null){
            //1. Update: updates the information on the screen such as registered movement or changed scenes
            update();
            //2. Draw: Redraw the updated information into the screen.
            repaint();
        }
    }
    public void update(){

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.white);

        g2.fillRect(100,100,tileSize,tileSize);

        g2.dispose();
    }
}
