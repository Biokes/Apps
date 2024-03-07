package MenstrualAppTest;

import MentrualApp.MenstrualApp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}
