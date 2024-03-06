package assignmentsAndTasks;

import fireDrill1.SevenSegmentsDisplay;
import fireDrill1.fireDrill2.InvalidNumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SevenSegmentsDisplayTest {
    @Test
    void onesInIndexZeroReturnsItAsterisk(){
        assertEquals("******",SevenSegmentsDisplay.indexZero("1010230980"));
        assertEquals("      ",SevenSegmentsDisplay.indexZero("0010230980"));

    }
    @Test
    void onesInIndexSixReturnsItAsterisks(){
        assertEquals("******",SevenSegmentsDisplay.indexSix("1010211980"));
        assertEquals("      ",SevenSegmentsDisplay.indexSix("0010200980"));

    }
    @Test
    void testOnesInIndexThreeReturnsItAsterisks(){
        assertEquals("******",SevenSegmentsDisplay.indexThree("1011210980"));
        assertEquals("      ",SevenSegmentsDisplay.indexThree("0010200980"));
    }
    @Test
    void testZeroesAndOnesInIndexOneAndFiveDraws(){
        assertEquals("*    *",SevenSegmentsDisplay.indexOne("1111210980"));
        assertEquals("      ",SevenSegmentsDisplay.indexOne("0000200980"));
        assertEquals("     *",SevenSegmentsDisplay.indexOne("1111200980"));
        assertEquals("*     ",SevenSegmentsDisplay.indexOne("0010210980"));

    }
    @Test
    void testZeroesAndOnesInIndexTwoAndFourDraws(){
        assertEquals("*    *",SevenSegmentsDisplay.indexOne("1111110980"));
        assertEquals("      ",SevenSegmentsDisplay.indexOne("0000000980"));
        assertEquals("     *",SevenSegmentsDisplay.indexOne("1111000980"));
        assertEquals("*     ",SevenSegmentsDisplay.indexOne("0000110980"));
    }
    @Test
    void testInvalidNumberThrowsException(){
        assertThrows(InvalidNumberException.class,()->SevenSegmentsDisplay.validate("1111110980"));
        assertThrows(InvalidNumberException.class,()->SevenSegmentsDisplay.validate("0000000980908"));
        assertThrows(InvalidNumberException.class,()->SevenSegmentsDisplay.validate("1111p00980"));
        assertThrows(InvalidNumberException.class,()->SevenSegmentsDisplay.validate("-0000980"));
    }

}
