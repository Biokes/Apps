package musicPlayer;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayer {
    private File song = new File("\"C:\\Users\\DELL\\Music\\audio\\Asake-Mo-gbe-1-(TrendyBeatz.com).mp3\"");
    private boolean isPlaying;
    public Object playSong(){
        try{
            if(song.exists()) {
                AudioInputStream music = AudioSystem.getAudioInputStream(song);
                Clip audio= AudioSystem.getClip();
                audio.open(music);
                audio.start();
                isPlaying = true;

            }
        }catch(Exception exception){
            return String.format("file does not exist.");
        }


        return String.format("file does not exist.");
    }

    public boolean isPlayingSong() {

        return false;
    }

    public void stopSong() {
        try{
            if(song.exists()) {
                AudioInputStream music = AudioSystem.getAudioInputStream(song);
                Clip audio= AudioSystem.getClip();
                audio.stop();
                isPlaying = false;
            }
        }catch(Exception exception){
            System.out.println(String.format("file does not exist."));
        }

    }
}
