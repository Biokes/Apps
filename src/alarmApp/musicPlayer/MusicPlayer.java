package alarmApp.musicPlayer;


import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;

public class MusicPlayer{
    private final File song = new File("C:\\Users\\DELL\\Downloads\1e745130-695b-40b2-b725-8e8e1c3c6082.wav");
    private boolean isPlaying;

    public void soundControl(int number){
        if(number ==1 )
            isPlaying = true;
        if(number == 2)
            isPlaying = false;
        try{
            if(song.exists()) {
                Clip audio = AudioSystem.getClip();
                switch (number){
                    case 1:
                        int snooze =  Integer.parseInt(JOptionPane.showInputDialog("Enter 0 to snooze.........."));
                        audio.start();
                        break;
                    case 2:
                        audio.stop();
                        isPlaying = false;
                        break;
                    default:
                        throw new IllegalArgumentException("invalid number");
                }


            }
        }catch(Exception exception){

            System.out.println("file does not exist.");
        }
    }
    public boolean isPlayingSong() {

        return isPlaying;
    }
    public void playSong(){

        soundControl(1);
    }

  public void stopSong() {
                soundControl(2);
                isPlaying = false;
    }
}
