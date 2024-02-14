package alarmApp;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;
import java.time.LocalTime;


public class Alarm {
    private LocalTime timerCounter = LocalTime.now();
    private LocalTime timeToBeep;
    public LocalTime getTime() {

        return LocalTime.now();
    }
    public void setTimer(int minutes){
        if(minutes < 0)
            throw new IllegalArgumentException("illegal argument entered\npls enter a valid number.");
        LocalTime time = LocalTime.from(timerCounter.plusMinutes(minutes));
        timeToBeep = time;
    }

    public String timeToBeep() {
        char []  beepTime = String.valueOf(timeToBeep).toCharArray();
        String timeToRing = convertTime(beepTime);
         return timeToRing;
    }

    public String convertTime(char[] numbers) {
        String output = "";
        for(int counter = 0; counter <= 4 ;){
            output += numbers[counter++];
        }
        return output;
    }

    public int notifier() {
        if(timeToBeep.equals(timerCounter))
            return 1;
        return 0;
    }

    public boolean isUserNotified() {
        if(notifier() ==1 )
            return true;
        return false;
    }

    public boolean isRinging() {
        if(notifier() == 1 )
            return true;

        return false;
    }
    public void ring(){
        try{
            File song = new File("C:\\Users\\DELL\\Downloads\1e745130-695b-40b2-b725-8e8e1c3c6082.wav");
            if(song.exists()) {
                Clip audio = AudioSystem.getClip();
                audio.open();
                audio.start();
                JOptionPane.showInputDialog(null,"preass okay to stop ALARM");
                }


        }catch(Exception exception){

            throw new IllegalArgumentException("invalid number");
        }
    }
    public void alarmClock(){

        setTimer(1);
        int count =0;
        while(!timerCounter.equals(timeToBeep)){
            System.out.println(count++);
            }
        if(timerCounter.equals(timeToBeep)){
            System.out.println("Alarm time out!!!!!!!");
            ring();
        }
    }

}
