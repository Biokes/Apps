package appsTest;

import assignmentsAndTasks.MenstrualApp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MenstrualAppTest {
    private MenstrualApp app = new MenstrualApp();
    @BeforeEach
    void testNewObject(){

        MenstrualApp app = new MenstrualApp();
    }
    @Test
    void testThatDateCanBeChecked(){

        assertTrue(app.isDateValid("31/12/2002"));
    }
    @Test
    void testThatInvalidAreNotAccepted(){

        assertThrows(IllegalArgumentException.class,()->app.isDateValid("31/13/2002"));

    }
    @Test
    void testThatInvalidDateAreNotAccepted0(){
        String lastSeen = "3.12/2001";
        assertThrows(IllegalArgumentException.class,()->app.isDateValid(lastSeen));
    }
    @Test
    void testThatInvalidDateAreNotAccepted1(){
        String lastSeen = "3.12.2001";
        assertThrows(IllegalArgumentException.class,()->app.isDateValid(lastSeen));
    }
    @Test
    void testThatInvalidDateAreNotAccepted2(){
        String lastSeen = "3\12.2001";
        assertThrows(IllegalArgumentException.class,()->app.isDateValid(lastSeen));
    }
    @Test
    void testThatInvalidDateAreNotAccepted3(){
        String lastSeen = "3i\12.2001";
        assertThrows(IllegalArgumentException.class,()->app.isDateValid(lastSeen));
    }
    @Test
    void testThatInvalidDateAreNotAccepted4(){
        String lastSeen = "3l/12.2001";
        assertThrows(IllegalArgumentException.class,()->app.isDateValid(lastSeen));
    }
    @Test
    void testThatInvalidDateAreNotAccepted5(){
        String lastSeen = "39/12/2001";
        assertThrows(IllegalArgumentException.class,()->app.isDateValid(lastSeen));
    }
    @Test
    void testThatInvalidDateAreNotAccepted6(){
        String lastSeen = "30/02/2001";
        assertThrows(IllegalArgumentException.class,()->app.isDateValid(lastSeen));
    }
    @Test
    void testThatInvalidDateAreNotAccepted7(){
        String lastSeen = "30/02/2001";
        assertThrows(IllegalArgumentException.class,()->app.isDateValid(lastSeen));
    }
    @Test
    void testThatInvalidDateAreNotAccepted8(){
        String lastSeen = "-5/02/2001";
        assertThrows(IllegalArgumentException.class,()->app.isDateValid(lastSeen));
    }
    @Test
    void testThatInvalidDateAreNotAccepted9(){
        String lastSeen = "31/22/2001";
        assertThrows(IllegalArgumentException.class,()->app.isDateValid(lastSeen));
    }
    @Test
    void testThatInvalidDateAreNotAccepted10(){
        String lastSeen = "31/22/2001";
        assertThrows(IllegalArgumentException.class,()->app.isDateValid(lastSeen));
    }
    @Test
    void testThatInvalidDateAreNotAccepted11(){
        String lastSeen = "31/-2/2001";
        assertThrows(IllegalArgumentException.class,()->app.isDateValid(lastSeen));
    }
    @Test
    void testThatInvalidDateAreNotAccepted12(){
        String lastSeen = "31/0/2001";
        assertThrows(IllegalArgumentException.class,()->app.isDateValid(lastSeen));
    }
    @Test
    void testThatInvalidDateAreNotAccepted13(){
        String lastSeen = "31/0/-9871";
        assertThrows(IllegalArgumentException.class,()->app.isDateValid(lastSeen));
    }
    @Test
    void testThatInvalidDateAreNotAccepted14(){
        String lastSeen = "31/0/9871";
        assertThrows(IllegalArgumentException.class,()->app.isDateValid(lastSeen));
    }
    @Test
    void testThatInvalidDateAreNotAccepted15(){
        String lastSeen = "31/9/9871";
        assertThrows(IllegalArgumentException.class,()->app.isDateValid(lastSeen));
    }
    @Test
    void testThatInvalidDateAreNotAccepted16(){
        String lastSeen = "30/9/2071";
        assertThrows(IllegalArgumentException.class,()->app.isDateValid(lastSeen));
    }
    @Test
    void testThatInvalidDateAreNotAccepted17(){
        String lastSeen = "30/9/2071";
        assertThrows(IllegalArgumentException.class,()->app.isDateValid(lastSeen));
    }
    @Test
    void testThatInvalidDateAreNotAccepted18(){
        String lastSeen = "30/9/2009";
        assertTrue(app.isDateValid(lastSeen));
    }
    @Test
    void testThatInvalidDateAreNotAccepted19(){
        String lastSeen = "29/02/2008";
        assertTrue(app.isDateValid(lastSeen));
    }
}
