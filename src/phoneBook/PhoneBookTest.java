package phoneBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookTest {
    PhoneBook phoneBook = new PhoneBook();
    @BeforeEach
    void testObjectIsNotNull(){
        assertNotNull(phoneBook);
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
    void testNumbersaved(){
        assertTrue(phoneBook.saveNumber("Asake", "0912342356789"));
    }
    @Test
    void testIfNumberIsValid(){
        String numberGiven = "567189`0";
        assertFalse(phoneBook.isNumberValid(numberGiven));

    }
    @Test
    void testIfNumberOIsValid(){
        String numberGiven = "5671890";
        assertFalse(phoneBook.isNumberValid(numberGiven));
    }

}
