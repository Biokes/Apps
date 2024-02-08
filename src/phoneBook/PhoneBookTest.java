package phoneBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookTest {
    PhoneBook phoneBook = new PhoneBook();
    @BeforeEach
    void testNewObject(){

        PhoneBook phoneBook = new PhoneBook();
    }
    @Test
    void testNumberAddedISSaved(){
        String nameGiven = "Abbey";
        String numberGiven = "09123456789";
        phoneBook.saveNumber(nameGiven, numberGiven);
        assertEquals(0,phoneBook.searchByName(nameGiven));
        assertEquals(0,phoneBook.searchByNumber(numberGiven));
    }
    @Test
    void testNumberSaved(){
        assertTrue(phoneBook.saveNumber("Asake", "0912342356789"));
    }
    @Test
    void testIfNumberIsValidForWrongInputs(){
        String numberGiven = "567189`0";
        assertFalse(phoneBook.isNumberValid(numberGiven));

    }
    @Test
    void testIfNumberIsValid(){
        String numberGiven = "5671890";
        assertTrue(phoneBook.isNumberValid(numberGiven));
    }
@Test
    void testIfNameIsSaved(){
        phoneBook.saveNumber("biokes","09876543212");
        assertEquals(0,phoneBook.searchByName("biokes"));
}
@Test
    void testSavedNumberIsDeleted(){
    String nameGiven = "Abbey";
    String numberGiven = "09123456789";
    phoneBook.saveNumber(nameGiven, numberGiven);
    assertEquals(0,phoneBook.searchByName(nameGiven));
    assertEquals(0,phoneBook.searchByNumber(numberGiven));
    assertEquals("Number deleted successfully..👌👌👌👌", phoneBook.deleteNumber("Abbey"));
}
@Test
    void testNumberNotSavedCantBeDeleted(){
    assertEquals("no match to the name entered\uD83D\uDE12\uD83D\uDE12", phoneBook.deleteNumber("Abbey"));

}
@Test
    void testNamesSortedNames(){
    phoneBook.saveNumber("biokes","09876543212");
    phoneBook.saveNumber("Aiokes","09876543212");
    phoneBook.saveNumber("aiokes","09876543212");
    phoneBook.saveNumber("Siokes","09876543212");
    phoneBook.sortNames();
    assertEquals(0,phoneBook.searchByName("Aiokes"));
    assertEquals(1,phoneBook.searchByName("aiokes"));
    assertEquals(2,phoneBook.searchByName("biokes"));
    assertEquals(3,phoneBook.searchByName("Siokes"));

}
}
