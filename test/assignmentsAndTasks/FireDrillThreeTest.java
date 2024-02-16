package assignmentsAndTasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FireDrillThreeTest {


    @Test
     void testTaskOne() {
        int[] expectedValues = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(expectedValues, FireDrillThree.taskOne(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
    }
        @Test
        void testTaskTwo(){
        int [] numbers = {1,2,3,4,5,6};
        String output = """
                1
                2
                3
                4
                5
                6
                """;
        assertEquals(output, FireDrillThree.taskTwo(numbers));
        }
        @Test
        void testTaskThree(){
            int [] numbers = {1,2,3,4,5,6};
            String expected = "1 2 3 4 5 6 ";
            assertEquals(expected, FireDrillThree.taskThree(numbers));
        }
        @Test
        void testTaskFour(){
            int [] numbers = {1,2,3,4,5,6};
            int [] expected = {1,3,5};
            assertArrayEquals(expected, FireDrillThree.taskFour(numbers));
        }
        @Test
        void testTaskFive(){
        int[] given ={1,2,3,4,5,6,7,8,9,0};
        int [] expected  = {2,4,6,8,0};
        assertArrayEquals(expected,FireDrillThree.taskFive(given));
        }
        @Test
        void testTaskSix(){
            int [] numbers = {1,2,3,4,5,6};
            int expected = 9;
            assertEquals(expected, FireDrillThree.taskSix(numbers));
        }
    @Test
    void testTaskSeven(){
        int[] given ={1,2,3,4,5,6,7,8,9,0};
        int expected  = 20;
        assertEquals(expected, FireDrillThree.taskSeven(given));
    }
    @Test
    void testTaskEight(){
        int [] numbers = {1,2,3,4,5,6};
        int expected = 1;
        assertEquals(expected, FireDrillThree.taskEight(numbers));
    }
    @Test
    void testTaskNine(){
        int [] numbers = {1,2,3,4,5,6};
        int expected = 2;
        assertEquals(expected, FireDrillThree.taskNine(numbers));
    }
    @Test
    void teatTaskTen(){
        int [] numbers = {1,2,3,4,5,6};
        int expected = 5;
        assertEquals(expected, FireDrillThree.taskTen(numbers));
    }
    @Test
    void testTaskEleven(){
        int[] given ={1,2,3,4,5,6,7,8,9,0};
        int expected  = 8;
        assertEquals(expected,FireDrillThree.taskEleven(given));
    }
    @Test
    void testTaskTwelve(){
    int[] given =      {1,2,3,4,5,6,7,8,9,0};
    int [] expected  = {2,1,4,3,6,5,8,7,0,9};
    assertArrayEquals(expected,FireDrillThree.taskTwelve(given));
}
    @Test
    void testTaskThirteen(){
        int[] given =      {1,2,3,4,5,6,7,8,9,0};
        int [] expected  = {1,2,3,4,5,6,7,8,9,0};
        assertArrayEquals(expected,FireDrillThree.taskThirteen(given));
    }
    @Test
    void testTaskFourteen() {
        int[] given =      {1,2,3,4,5,6,7,8,9,0};
        int [] expected  = {1,2,3,4,5,6,7,8,9,0};
        assertArrayEquals(expected,FireDrillThree.taskFourteen(given));
    }
    @Test
    void testTaskFifteen(){
        int[] given =      {1,2,3,4,5,6,7,8,9,0};
        int [] expected  = {2,1,4,3,6,5,8,7,0,9};
        assertArrayEquals(expected,FireDrillThree.taskFifteen(given));
    }
    @Test
    void testTaskSixteen(){
        int[] given =      {1,2,4,4,5,6,7,8,9,0};
        int [] expected  = {2,1,4,4,6,5,8,7,0,9};
        assertArrayEquals(expected,FireDrillThree.taskSixteen(given));
    }
    @Test
    void testTaskSeventeen(){
        String given1 = "name";
        String name2 = "wear";
       String expected  = "weme naar";
        assertEquals(expected,FireDrillThree.taskSeventeen(given1, name2));
    }
    @Test
    void testThatOddsAreReplacedWithZerosAndEvensAreReplacedWithOnes(){
        int [] given = {4,5,8,8,8,2,9};
        int [] expected = {0,1,0,0,0,0,1};
        assertArrayEquals(expected, FireDrillThree.taskEighteen(given));
    }
    @Test
    void testThatOddsAreReplaceWithZerosAndEvensAreReplacedWithTrueAndFalse() {
        int [] given = {4,5,8,8,8,2,9};
        boolean [] expected = {false,true,false,false,false,false,true};
        assertArrayEquals(expected, FireDrillThree.taskNineteen(given));
    }

}
