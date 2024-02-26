package alarmApp;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;
import java.time.LocalTime;


public class Alarm {
    private final LocalTime timerCounter = LocalTime.now();
    private LocalTime timeToBeep;
    public LocalTime getTime(){

        return LocalTime.now();
    }
    public void setTimer(int minutes){
        if(minutes < 0)
            throw new IllegalArgumentException("illegal argument entered\npls enter a valid number.");
        timeToBeep = LocalTime.from(timerCounter.plusMinutes(minutes));
    }

    public String timeToBeep() {
        char []  beepTime = String.valueOf(timeToBeep).toCharArray();
        return convertTime(beepTime);
    }

    public String convertTime(char[] numbers) {
        String output = "";
        for(int counter = 0; counter <= 4 ;)
            output += numbers[counter++];
        return output;
    }

    public int notifier() {
        if(timeToBeep.equals(timerCounter))
            return 1;
        return 0;
    }

    public boolean isUserNotified() {
       return notifier() ==1;

    }

    public boolean isRinging() {
        return notifier() == 1;

    }
    public static void ring(){
        File song = new File("C:\\Users\\DELL\\Downloads\1e745130-695b-40b2-b725-8e8e1c3c6082.wav");
        try{
                Clip audio = AudioSystem.getClip();
                audio.open();
                audio.start();
                JOptionPane.showInputDialog("press okay to stop ALARM");


        }catch(Exception exception){

            JOptionPane.showInputDialog("invalid number");
        }
    }
    public void alarmClock(){

        setTimer(1);
        int count =0;
        while(!timerCounter.equals(timeToBeep)){
            if(timerCounter.equals(timeToBeep))
                break;
            }
        if(timerCounter.equals(timeToBeep)){
            JOptionPane.showInputDialog(count++);
            JOptionPane.showInputDialog("Alarm time out!!!!!!!");
            ring();
        }
    }



}
