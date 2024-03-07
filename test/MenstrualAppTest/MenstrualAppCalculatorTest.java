package MenstrualAppTest;

import MentrualApp.InvalidDateException;
import MentrualApp.MenstrualApp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MenstrualAppCalculatorTest {
    private MenstrualApp app;

    @BeforeEach
    void createNewObject() {
        app = new MenstrualApp();
    }

    @Test
    void dateGiven_testDateIsValid() {
        assertFalse(app.validateDate("22/10/2023"));
        assertFalse(app.validateDate("22/10/2013"));
        assertTrue(app.validateDate("22/10/2033"));
        assertFalse(app.validateDate("22/10/2012"));
        assertTrue(app.validateDate("22/10/2025"));
    }

    @Test
    void testInvalidDate_throwsException() {
        assertThrows(InvalidDateException.class, () -> app.validateDate("12/23/2090"));
        assertThrows(InvalidDateException.class, () -> app.validateDate("12-23/2090"));
        assertThrows(InvalidDateException.class, () -> app.validateDate("112/23/2090"));
        assertThrows(InvalidDateException.class, () -> app.validateDate("12/023/2090"));
    }

}
