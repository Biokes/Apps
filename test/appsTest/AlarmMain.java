package appsTest;

import alarmApp.Alarm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class AlarmMain {
    private Alarm alarm = new Alarm();
    private LocalTime time = LocalTime.now();

    @BeforeEach
        void testThatANewTimeIsCreated(){
        Alarm alarm = new Alarm();
        LocalTime time = LocalTime.now();
    }
    @Test
    void testThatTimeIsGotten(){

        assertEquals(time.now(),alarm.getTime());
    }
    @Test
    void testThatCharArrayCanReturnInHourAndMinuteFormat(){
        char [] numbers = {'2','2',':','3','6',':','2','7','.','2','0','9','2','8','4','6','0','0'};
        assertEquals("22:36", alarm.convertTime(numbers));
        char [] numbers1 = {'2',':','3','6',':','2','7','.','2','0','9','2','8','4','6','0','0'};
        assertEquals("2:36:", alarm.convertTime(numbers1));
    }
    @Test
    void testTimerCanBeSet(){
       alarm.setTimer(2);
       assertEquals("23:43", alarm.timeToBeep());
    }
    @Test
    void testThatIcanCollectInputAndSetTimerForPositiveNumbers(){
        alarm.setTimer(2);
        assertEquals("23:43", alarm.timeToBeep());

    }
    @Test
    void testThatNegativeNumbers_DoesNotWork(){

        assertThrows(IllegalArgumentException.class,()->alarm.setTimer(-1));
    }
    @Test
    void testThatAlarmTimeCanBeReset(){
        assertThrows(IllegalArgumentException.class,()->alarm.setTimer(-1));
        alarm.setTimer(2);
        assertEquals("23:43", alarm.timeToBeep());
    }
    @Test
    void testThatUserNotifierCanNotify(){
        assertEquals(time.now(),alarm.getTime());
        alarm.setTimer(0);
        assertEquals("23:51", alarm.timeToBeep());
        assertEquals(1,alarm.notifier());
    }
    @Test
    void testThatUserCanBeNotifiedWhenTimeReaches(){
        assertEquals(time.now(),alarm.getTime());
        alarm.setTimer(0);
        assertEquals("23:59", alarm.timeToBeep());
        assertTrue(alarm.isUserNotified());
    }
    @Test
    void testThatAudioPlayerIsActive(){
        alarm.setTimer(0);
        assertEquals("15:21", alarm.timeToBeep());
        assertTrue(alarm.isRinging());
    }
    }
