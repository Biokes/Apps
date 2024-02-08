import bike.Bike;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BikeTest {
    private Bike bike = new Bike();
    @BeforeEach
    void testThatIHaveBike(){
        Bike bike = new Bike();

    }
    @Test
    void testBikeIsOff_thenITurnItOn(){
        assertFalse(bike.isOn());
        bike.toggle();
        assertTrue(bike.isOn());
        assertEquals(1,bike.getGear());
    }
    @Test
    void testBikeIsOn_thenITurnItOff(){
        assertFalse(bike.isOn());
        bike.toggle();
        assertTrue(bike.isOn());
        bike.toggle();
        assertFalse(bike.isOn());
    }
    @Test
    void testBikeIsOnAndNotMoving(){
        bike.toggle();
        assertEquals(0,bike.checkSpeed());
        assertEquals(1,bike.getGear());

    }
    @Test
    void testBikeIsOnAndMoving(){
        bike.toggle();
        for(int counter = 1; counter <= 26; counter++){
            bike.accelerate();
        }
        assertEquals(31,bike.checkSpeed() );
        assertEquals(3,bike.getGear());
        bike.toggle();
        assertEquals(0, bike.checkSpeed());
        assertEquals(0,bike.getGear());

    }
    @Test
    void testThatBikeDoesNotDecelerateToNegative(){
        bike.toggle();
        for (int counter   = 1; counter   < 3; counter  ++) {
            bike.accelerate();
        }
        assertEquals(2,bike.checkSpeed());
        for(int counter = 1; counter <= 20; counter++){
            bike.decelerate();
        }
        assertEquals(0,bike.checkSpeed());
    }
    @Test
    void testThatBikeCanDecelerateAndAccelerateOnMotion(){
        bike.toggle();
        assertEquals(0,bike.checkSpeed());
        for(int counter = 1; counter <= 9; counter++){
            bike.accelerate();
        }
        bike.decelerate();
        assertEquals(8,bike.checkSpeed());
        for(int counter = 1; counter <= 6; counter++){
            bike.decelerate();
        }
        assertEquals(2,bike.checkSpeed());

    }
    @Test
    void testThatBikeCanDecelerateAndGearChanges(){
        bike.toggle();
        assertTrue(bike.isOn());
        for(int counter = 1; counter < 20; counter++){
            bike.accelerate();
        }
        assertEquals(1,bike.getGear());
        assertEquals(19,bike.checkSpeed());
        assertEquals(1,bike.getGear());
        assertEquals(18,bike.decelerate());
        assertEquals(19,bike.accelerate());
        assertEquals(1,bike.getGear());
        assertEquals(20,bike.accelerate());
        assertEquals(1,bike.getGear());
        for(int counter = 1; counter <= 1; counter++){
            bike.decelerate();
        }
        assertEquals(1,bike.getGear());
        assertEquals(19,bike.checkSpeed());
        for(int counter = 1; counter < 20; counter++){
            bike.accelerate();
        }
        assertEquals(4,bike.getGear());
        assertEquals(75,bike.checkSpeed());
        bike.toggle();
        assertEquals(0,bike.getGear());
        assertEquals(0,bike.checkSpeed());
    }
    @Test
    void testThatGearAutoChangesTheGear(){
        bike.toggle();
        for(int number = 0;number < 25; number++){
            bike.accelerate();
        }
        assertEquals(2,bike.getGear());
        assertEquals(29, bike.checkSpeed());
    }
}
