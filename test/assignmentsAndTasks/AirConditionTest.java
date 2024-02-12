package assignmentsAndTasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AirConditionTest {

    @Test
    void testThatACIsOn(){
    AirCondition airCondition = new AirCondition();
        airCondition.onAirCondition();
        assertEquals(true, airCondition.checkACStatus());
    }
    @Test
    void testThatACIsOff(){
        AirCondition airCondition = new AirCondition();
        airCondition.offAirCondition();
        assertEquals(false, airCondition.checkACStatus());
    }
    @Test
    void testThatACIsOffAfterOningIt(){
        AirCondition airCondition = new AirCondition();
        airCondition.onAirCondition();
        airCondition.offAirCondition();
        assertEquals(false, airCondition.checkACStatus());
    }
    @Test
    void testThatTemperatureDoesNoExceedLimits(){
        AirCondition airCondition = new AirCondition();
        airCondition.onAirCondition();
        assertEquals("temperature : 19degrees", airCondition.increaseTemperature(3));
        assertEquals("temperature : 30degrees", airCondition.increaseTemperature(12));

    }
    @Test
    void testThatTemperatureIsNotBelowLimits(){
        AirCondition airCondition = new AirCondition();
        airCondition.onAirCondition();
        assertEquals("temperature : 19degrees", airCondition.increaseTemperature(3));
        assertEquals("temperature : 18degrees", airCondition.decreaseTemperature());
        assertEquals("temperature : 16degrees", airCondition.decreaseTemperature(12));

    }
    @Test
    void testThatAcIsNotCoolingWhileOff(){
        AirCondition airCondition = new AirCondition();
        airCondition.increaseTemperature(5);
        assertEquals("ac is off",airCondition.increaseTemperature(5));
        airCondition.onAirCondition();
        assertEquals("temperature : 19degrees", airCondition.increaseTemperature(3));
        assertEquals("temperature : 18degrees", airCondition.decreaseTemperature());
        airCondition.offAirCondition();
    }

}
