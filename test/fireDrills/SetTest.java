package fireDrills;

import assignmentsAndTasks.MySet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.aggregator.ArgumentAccessException;

import static org.junit.jupiter.api.Assertions.*;


public class SetTest {
    private MySet set = new MySet();
    @BeforeEach
    void creatNewObject(){

        MySet set = new MySet();
    }
    @Test
    void testThatICanAddElementToSet(){
        String element1 = "name";
        set.add(element1);
    }
    @Test
    void testThatTheSetISEmpty(){

        assertTrue(set.isEmpty());
    }
    @Test
    void testThatSetISNotEmptyAfterAddingElements(){
        assertTrue(set.isEmpty());
        String element1 = "name";
        set.add(element1);
        assertFalse(set.isEmpty());
    }

    @Test
    void testThatSetCanDoesNotContainDuplicates(){
        assertTrue(set.isEmpty());
        String element1 = "name";
        set.add(element1);
        String element2 = "name1";
        set.add(element2);
        String element3 = "name2";
        set.add(element3);
        String element4 = "name3";
        set.add(element4);
        String element5 = "name4";
        set.add(element5);
        set.clear();
        assertTrue(set.isEmpty());
    }
    @Test
    void testThatElementsAreGottenByIndex(){
        String element1 = "name";
        set.add(element1);
        assertEquals(element1, set.getElement(0));
    }
    @Test
    void testThatIndexEmpty_areNotAvailableToClient(){
        String element1 = "name";
        set.add(element1);
        assertEquals(element1, set.getElement(0));
        assertThrows(ArgumentAccessException.class,()->set.getElement(1));

    }
    @Test
    void testEmptySetIndicesCannotBeGotten(){
        assertTrue(set.isEmpty());
        assertThrows(ArgumentAccessException.class,()->set.getElement(0));
    }
    @Test
    void testThatNegativeIndicesAreRestricted_whenSetIsEmpty(){
        assertTrue(set.isEmpty());
        String element1 = "name";
        set.add(element1);
        assertThrows(IllegalArgumentException.class,()->set.getElement(-1));
    }
    @Test
    void testSetElementsCanBeAsMuchAsPossible(){
        assertTrue(set.isEmpty());
        set.add("name");
        set.add("values");
        set.add("element1");
        set.add("element2");
        set.add("element11");
        set.add("element16");
    }
    @Test
    void testSizeCanBEGotten_whenSetIsEmpty(){
        assertTrue(set.isEmpty());
        assertEquals(0, set.getSize());
    }
    @Test
    void testSizeCAnBeGotten_whenSetIsNotEmpty(){
        assertTrue(set.isEmpty());
        set.add("name");
        assertEquals(1, set.getSize());
    }
    @Test
    void testSizeAfterArrayIsCleared(){
        assertTrue(set.isEmpty());
        set.add("name1");
        set.add("name2");
        set.add("name3");
        set.add("name4");
        assertEquals(4, set.getSize());
        set.clear();
        assertEquals(0, set.getSize());
    }
    @Test
    void testNewSetDoesNotContainDuplicates_whenSetIsEmpty(){
        assertTrue(set.isEmpty());;
        assertFalse(set.checkDuplicates("name"));
    }
    @Test
    void testNewSetDoesNotContainDuplicates_whenSetIsNotEmpty(){
        assertTrue(set.isEmpty());
        set.add("name");
        assertEquals("name",set.getElement(0));
        assertTrue(set.checkDuplicates("name"));
    }
    @Test
    void testNewSetDoesNotContainDuplicates_whenThereISMoreThanOneElement(){
        assertTrue(set.isEmpty());
        set.add("name");
        assertTrue(set.checkDuplicates("name"));
    }
    @Test
    void testThatDuplicatedElementsCausesException(){
        assertTrue(set.isEmpty());
        set.add("name");
        assertThrows(IllegalArgumentException.class,()->set.add("name"));
    }
    @Test
    void testThatNoDuplicates_whenBiggerSizeIsCreated(){
        assertTrue(set.isEmpty());
        set.add("name1");
        set.add("name2");
        set.add("name3");
        set.add("name11");
        set.add("name21");
        set.add("name33");
        assertEquals(6,set.getSize());
    }

    @Test
    void testSetCanBeReturnedAsAnArray(){
        assertTrue(set.isEmpty());
        set.add("name1");
        set.add("name2");
        String [] output = {"name1", "name2"};
        assertArrayEquals(output, set.toArray());
    }

}
