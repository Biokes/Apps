package fireDrills;

import fireDrill1.FireDrill;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FireDrillTest {
    @Test
    void testAgeGetter(){
       assertEquals( 1,FireDrill.getAge2("12/12/2022"));
    }
    @Test
    void testAgeGetter2(){
        assertEquals( 2,FireDrill.getAge2("12/01/2022"));
        assertEquals( 1,FireDrill.getAge2("12/03/2022"));
        assertEquals(16,FireDrill.getAge2("12/12/2007"));
        assertEquals( 23,FireDrill.getAge2("31/12/2000"));
        assertEquals( 17,FireDrill.getAge2("27/02/2006"));

    }


}
