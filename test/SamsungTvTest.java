import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import television.Television;

import static org.junit.jupiter.api.Assertions.*;

public class SamsungTvTest {
    private final SamsungTv mySamsungTv = new SamsungTv();
    @BeforeEach
    public void testTelevision(){
        SamsungTv mySamsungTv = new SamsungTv();
    }
    @Test
    public void testThatTvIsOff_AndItIsTurnedOn(){
        assertFalse(mySamsungTv.isOn());
        mySamsungTv.toggle();
        assertTrue(mySamsungTv.isOn());
    }
    @Test
    public void testThatTvIsOff_AndItIsTurnedOff(){
        mySamsungTv.toggle();
        assertTrue(mySamsungTv.isOn());
        mySamsungTv.toggle();
        assertFalse(mySamsungTv.isOn());
    }
    @Test
    public void testThatICanTurnTvOnAndOff(){
        assertFalse(mySamsungTv.isOn());
        mySamsungTv.toggle();
        assertTrue(mySamsungTv.isOn());
    }
    @Test
    public void testThatVolumeIncreases(){
        mySamsungTv.toggle();
        mySamsungTv.increaseVolume();
        mySamsungTv.increaseVolume();
       assertEquals(2, mySamsungTv.getVolume());
       mySamsungTv.increaseVolume();
        assertEquals(3, mySamsungTv.getVolume());
        }
    @Test
    public void testThatVolumeDecreases(){
        mySamsungTv.toggle();
        mySamsungTv.increaseVolume();
        mySamsungTv.increaseVolume();
        assertEquals(2, mySamsungTv.getVolume());
        mySamsungTv.decreaseVolume();
        mySamsungTv.decreaseVolume();
        assertEquals(0, mySamsungTv.getVolume());
    }
    @Test
    public void testThatChannelIncreases(){
        mySamsungTv.toggle();
        mySamsungTv.channelsIncreases();
        assertEquals(2, mySamsungTv.getChannels());
        mySamsungTv.channelsIncreases();
        assertEquals(3, mySamsungTv.getChannels());

    }
    @Test
    public void testThatChannelDecreases(){
        mySamsungTv.toggle();
        mySamsungTv.channelsIncreases();
        assertEquals(2, mySamsungTv.getChannels());
        mySamsungTv.channelsDecreases();
        assertEquals(2, mySamsungTv.getChannels());


    }

}

