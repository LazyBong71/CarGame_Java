import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;

public class CarImage {

    // Variable Create For Background Image
    Image carImage;

    // Variable Create For Car Image
    Image carRightImage;
    Image carLeftImage;
    Image carRunningRight;
    Image carRunningLeft;
    ImageIcon imageIcon;

    // Variable Create For Audio
    AudioInputStream carDriveSound;
    Clip carSoundPlayer;

    int x;

    CarImage() throws Exception {

        //Add Car Right png in Variable
        imageIcon = new ImageIcon("carRight.png");
        carRightImage = imageIcon.getImage();

        //Add Car Left png in Variable
        imageIcon = new ImageIcon("carLeft.png");
        carLeftImage = imageIcon.getImage();

        //Add Car Right Running png in Variable
        imageIcon = new ImageIcon("runningRight.gif");
        carRunningRight = imageIcon.getImage();

        //Add Car Left Running png in Variable
        imageIcon = new ImageIcon("runningLeft.gif");
        carRunningLeft = imageIcon.getImage();

        //Add Car png in Variable
        carImage = carRightImage;
        x = 100;

        //Add Audion Sound in Variable;
        carDriveSound = AudioSystem.getAudioInputStream(new File("car_drive_sound.wav"));
        carSoundPlayer = AudioSystem.getClip();
        if(carSoundPlayer.isOpen() == false)
            carSoundPlayer.open(carDriveSound);
    }

    //Car Move Method with Keypress
    void move(KeyEvent e) throws Exception {

        //Condition For Right Keypress
        if(e.getKeyCode() == 39){
            carImage = carRunningRight; //Show Car Image
            x = x+7; // Car Image Position Moving by 7
            carSoundPlayer.loop(Clip.LOOP_CONTINUOUSLY); //Play Sound
        }

        //Condition For Left Keypress
        if(e.getKeyCode() == 37){
            carImage = carRunningLeft; //Show Car Image
            x = x-7; //Car Image position Moving Back by 7
            carSoundPlayer.loop(Clip.LOOP_CONTINUOUSLY); //Play Audio
        }
    }

    //Method Apply When Key Release
    void stop(KeyEvent e){

        //Condition For Right Key Release
        if(e.getKeyCode() == 39){
            carImage = carRightImage; ////Show Stop Car Right Image
            carSoundPlayer.stop(); //Stop Sound
            carSoundPlayer.setFramePosition(0); //Sound Move to Start Position
        }

        //Condition For Right Key Release
        if(e.getKeyCode() == 37){
            carImage = carLeftImage; //Show Stop Car Left Image
            carSoundPlayer.stop(); //Stop Sound
            carSoundPlayer.setFramePosition(0); //Sound Move to Start Position
        }
    }

}
