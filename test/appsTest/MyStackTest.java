package appsTest;

import assignmentsAndTasks.MyStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class MyStackTest {
    private MyStack stack = new MyStack(5);
    @BeforeEach
    void testThatNewAStackIsCreated(){

        MyStack stack = new MyStack(5);
    }

    @Test
    void testThatElementsStackIsEmpty() {

        assertTrue(stack.isEmpty());
    }
    @Test
    void testThatElementsCouldBeAddedToStack(){
        assertTrue(stack.isEmpty());
        stack.push("name");
    }
    @Test
     void testStackIsNotEmpty_afterElementsArePushed(){
        assertTrue(stack.isEmpty());
        stack.push("name");
        assertFalse(stack.isEmpty());
    }
    @Test
    void testThatElementsIsAddedToStack(){
        assertTrue(stack.isEmpty());
        stack.push("name");
        assertEquals("name",stack.peek());
    }
    @Test
    void testThatElementsAreNotAddedBeyondStackSize(){
        assertTrue(stack.isEmpty());
        stack.push("name");
        stack.push("name");
        stack.push("name");
        stack.push("name");
        stack.push("name");
        assertThrows(StackOverflowError.class,()->stack.push("name"));
    }
    @Test
    void testThatElementsCannotBePoppedWhenStackIsEmpty(){
        assertTrue(stack.isEmpty());
        assertThrows(RuntimeException.class,()->stack.pop());
    }
    @Test
    void testThatElementsCanBePoppedFromStack(){
        assertTrue(stack.isEmpty());
        stack.push("name");
        stack.push("name1");
        stack.push("name2");
        stack.push("name3");
        stack.pop();
        assertEquals("name2",stack.peek());

    }
    @Test
    void testThatElementsCanBESearched(){
        stack.push("name");
        stack.push("name1");
        stack.push("name2");
        stack.push("name3");
        assertEquals(1,stack.search("name"));
    }
}
