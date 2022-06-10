package com.company;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class SE {

    Clip clip;

    public void setFile(String name) {

        try {
            File file =new File(name);
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(sound);
        }
        catch(Exception e) {

        }
    }
    public void play(String name) {

        clip.setFramePosition(0);
        clip.start();
    }

    public void loop(String name) {

        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(String name) {

        clip.stop();
    }
}