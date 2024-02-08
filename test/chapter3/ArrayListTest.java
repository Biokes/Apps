package chapter3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import taskAndAssignments.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class ArrayListTest {
    private ArrayList arrayList = new ArrayList();
    @BeforeEach
    void testThatIHaveANewArrayList(){
        ArrayList arrayList = new ArrayList();
    }
    @Test
    void testTheArrayListIsEmpty(){
        assertTrue(arrayList.isEmpty());
    }

    @Test
    void testThatListCanaddItems(){
        assertTrue(arrayList.isEmpty());
        arrayList.add("name");
    }
    @Test
    void testThatArrayListIsNotEmptyAfterAddingElements(){
        assertTrue(arrayList.isEmpty());
        arrayList.add("name");
        assertFalse(arrayList.isEmpty());
    }
    @Test
    void testThatMyArrayListIsNotEmptyWhenIAddItem(){
        assertTrue(arrayList.isEmpty());
        arrayList.add("name");
        assertFalse(arrayList.isEmpty());

    }
    @Test
    void testThatICanAddItemAndGetTheItemSaved(){
        assertTrue(arrayList.isEmpty());
        arrayList.add("name");
        assertFalse(arrayList.isEmpty());
        assertEquals("name",arrayList.getElement(0));
    }
    @Test
    void testElementNotAddedCantBeDeletedByIndex(){
        assertTrue(arrayList.isEmpty());
        arrayList.add("name");
        assertThrows(IllegalArgumentException.class, ()->arrayList.getElement(2));
    }
    @Test
    void testThatICanAddMoreThanOneElement(){
        assertTrue(arrayList.isEmpty());
        arrayList.add("name");
        arrayList.add("name1");
        arrayList.add("name2");
        assertEquals("name",arrayList.getElement(0));
        assertEquals("name1",arrayList.getElement(1));
        assertEquals("name2",arrayList.getElement(2));
    }
    @Test
    void testThatElementsCanBeGottenByIndex(){
        assertTrue(arrayList.isEmpty());
        arrayList.add("name");
        assertEquals("name",arrayList.getElement(0));
    }
    @Test
    void testElementsIndexIsGotten(){
        assertTrue(arrayList.isEmpty());
        arrayList.add("name");
        assertEquals(0,arrayList.getIndex("name"));
    }
    @Test
    void testThatElementsNotFoundThrows(){
        assertTrue(arrayList.isEmpty());
        arrayList.add("name");
        assertThrows(IllegalArgumentException.class,()->arrayList.getIndex("name1"));
    }
    @Test
    void testInsertElementsWithinRange(){
        assertTrue(arrayList.isEmpty());
        arrayList.add("name");
        arrayList.insert(1,"name1");
        assertEquals("name1",arrayList.getElement(1));
    }
    @Test
    void testThatIndexOutOfBoundCantBeAdded(){
        assertTrue(arrayList.isEmpty());
        assertThrows(ArrayIndexOutOfBoundsException.class,()->arrayList.insert(1,"name"));
    }

    @Test
    void testThatNegativeNumberCantBeInserted(){
        assertTrue(arrayList.isEmpty());
        arrayList.add("name");
        arrayList.insert(1,"name1");
        assertThrows(ArrayIndexOutOfBoundsException.class,()->arrayList.insert(-1,"name3"));

    }
    @Test
    void testThatNumberGreaterThanArrayListLength_isNotInserted(){
        assertTrue(arrayList.isEmpty());
        arrayList.add("name");
        arrayList.insert(1,"name1");
        assertThrows(ArrayIndexOutOfBoundsException.class,()->arrayList.insert(4,"name3"));
    }
    @Test
    void testThatArrayListCanRemoveElements(){
        assertTrue(arrayList.isEmpty());
        arrayList.add("name");
        assertEquals(0, arrayList.getIndex("name"));
        arrayList.removeElement("name");
        assertTrue(arrayList.isEmpty());
    }
    @Test
    void testThatArrayListCanBeCleared(){
        assertTrue(arrayList.isEmpty());
        arrayList.add("name");
        arrayList.clear();
        assertTrue(arrayList.isEmpty());
    }
    @Test
    void testThatListCanBeCleared_whenEmpty(){
        assertTrue(arrayList.isEmpty());
        arrayList.clear();
        assertTrue(arrayList.isEmpty());
    }
    @Test
    void testGetSize(){
        assertEquals(0,arrayList.size());
    }
    @Test
    void testThatArrayListLengthIsGotten(){
        assertTrue(arrayList.isEmpty());
        arrayList.clear();
        arrayList.add("name");
        arrayList.add("name1");
        arrayList.add("name2");
        assertEquals(3,arrayList.size());
    }

}
