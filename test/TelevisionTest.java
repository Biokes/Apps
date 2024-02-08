import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import television.Television;

import static org.junit.jupiter.api.Assertions.*;

public class TelevisionTest {
    private Television tv = new Television();

    @BeforeEach
    void testNewTelevision(){
        Television tv = new Television();
    }

    @Test
    void testThatTvIsOffInitially(){
        assertFalse(tv.isOn());
    }
    @Test
    void testThatICanOnTv(){
        tv.toggle();
        assertTrue(tv.isOn());
    }
    @Test
    void testThatICanOnAndOffTv(){
        tv.toggle();
        assertTrue(tv.isOn());
        tv.toggle();
        assertFalse(tv.isOn());
    }
    @Test
    void testThatICAnChangeStation() {
        tv.toggle();
        assertEquals("station 2", tv.nextStation());
        assertEquals("station 3", tv.nextStation());
        for (int counter = 1; counter <= 20; counter++) {
          tv.nextStation();
        }
        assertEquals("station 24", tv.nextStation());

    }
    @Test
    void testThatICanChangeStationBackward(){
        tv.toggle();
        for (int counter = 1; counter <= 5; counter++) {
            tv.nextStation();
        }
        assertEquals("station 5", tv.previousStation());
    }
    @Test
    void testThatICanChangeStationBackwardAndItDoesNotNegates(){
        tv.toggle();
        assertEquals("station 30", tv.previousStation());
    }
    @Test
    void testThatTvCanOnlyShowOnlyTheNumberOfStationAvailable(){
        tv.toggle();
        for (int counter = 1; counter <= 31; counter++) {
            tv.nextStation();
        }
        assertEquals("station 3", tv.nextStation());

    }
    @Test
    void testTvDecreasesVolume(){
        tv.toggle();
        assertEquals("volume : 1",tv.increaseVolume());
        assertEquals("volume : 0",tv.decreaseVolume());

    }
    @Test
    void testThatVolumeDoesNotIncreaseMoreThanMax(){
        tv.toggle();
        for (int counter = 0; counter < 65; counter++) {
            tv.increaseVolume();
        }
    }
    @Test
    void testThatVolumeIsNotNegative(){
        tv.toggle();
        assertEquals("Min volume : 0",tv.decreaseVolume());
        for (int counter = 0; counter < 30; counter++) {
            tv.increaseVolume();
        }
        for (int counter = 0; counter < 25; counter++) {
            tv.decreaseVolume();
        }
        assertEquals("volume : 3",tv.decreaseVolume());

    }
}
