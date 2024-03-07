package dispatchRiderTest;
import dispatch.Dispatch;
import fireDrill1.fireDrill2.InvalidNumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class DispatchTest {
    @Test
    void test_DispatchRiderAmountIsCalculated(){
        assertEquals(6920,Dispatch.wage(12));
        assertEquals(7400,Dispatch.wage(15));
        assertEquals(40000,Dispatch.wage(70));
        assertEquals(15200,Dispatch.wage(51));
        assertEquals(20250,Dispatch.wage(61));
    }
    @Test
    void invalidNumberOfDeliveriesThrowsException(){
        assertThrows(InvalidNumberException.class, ()-> Dispatch.wage(-12));
        assertThrows(InvalidNumberException.class, ()-> Dispatch.wage(-123));
    }
    @Test
    void invalidNumberGreaterTHanMaxOfDeliveriesThrowsException_(){
        assertThrows(InvalidNumberException.class, ()-> Dispatch.wage(101));
        assertThrows(InvalidNumberException.class, ()-> Dispatch.wage(190));
        assertEquals(5000,  Dispatch.wage(0));
    }
    @Test
    void testDispatchRiderAppWorksWell() {
        assertThrows(InvalidNumberException.class, () -> Dispatch.wage(101));
        assertThrows(InvalidNumberException.class, () -> Dispatch.wage(190));
        assertEquals(6920, Dispatch.wage(12));
        assertEquals(7400, Dispatch.wage(15));
        assertEquals(40000, Dispatch.wage(70));
        assertThrows(InvalidNumberException.class, () -> Dispatch.wage(-12));
        assertEquals(5000, Dispatch.wage(0));
    }
}