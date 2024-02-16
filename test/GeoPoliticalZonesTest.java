import chapter4.GeoZones;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeoPoliticalZonesTest {
    @Test
    void testThatNorthCentralStatesCanBeGotten(){
        GeoZones zone = GeoZones.NORTH_CENTRAL;
        assertArrayEquals(new String []{"benue", "fct", "kogi", "nasarawa", "niger", "plateau"},zone.getStates());
    }
    @Test
    void testGeoPoliticalZoneCouldBeGotten(){
        GeoZones zone = GeoZones.NORTH_CENTRAL;
        assertArrayEquals(new String []{"benue", "fct", "kogi", "nasarawa", "niger", "plateau"},zone.getStates());
        String state = "benue";
        assertEquals("You are from North Central.",zone.checkState(state));
    }

}
