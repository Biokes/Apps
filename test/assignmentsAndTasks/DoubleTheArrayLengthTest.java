package assignmentsAndTasks;

import fireDrill1.DoubleArrayLength;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoubleTheArrayLengthTest {
    private DoubleArrayLength doubleArrayLength = new DoubleArrayLength();

    @BeforeEach
    void testThatANewObjectIsCreated(){

        DoubleArrayLength doubleArrayLength = new DoubleArrayLength();
    }
    @Test
    void testThatICanCreateAnArrayAndGetItsLength(){
        int [] numbers = {4,5,8};
        assertEquals(6,doubleArrayLength.getLengthDoubled(numbers));
    }
    @Test
    void testThatICanReturnDoubleTheElementsValueAndReplaceThem(){

        assertArrayEquals(new int[]{4, 5, 8, 8, 10, 16},doubleArrayLength.getDoubled(new int[]{4,5,8}));
    }
}
