import chapter4.Person;
import chapter4.Problem;
import chapter4.Type;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class PersonTest {
    @Test
    void testThatPersonCanHave_financialProblem(){
        Person person = new Person();
        Problem prob1 = new Problem("no money", Type.FINANCIAL);
        person.add(prob1);

    }
    @Test
    void testThatPersonCanHave_EducationProblem(){
        Person person = new Person();
        Problem prob1 = new Problem("no money", Type.EDUCATION);
        person.add(prob1);

    }
    @Test
    void testThatPersonCanHave_TechnicalProblem(){
        Person person = new Person();
        Problem prob1 = new Problem("no money", Type.TECHNICAL);
        person.add(prob1);

    }
    @Test
    void testThatPersonCanHave_SpiritualProblem(){
        Person person = new Person();
        Problem prob1 = new Problem("no money", Type.SPIRITUAL);
        person.add(prob1);
    }

    @Test
    void testThatPersonCanGet_ListOfProblems(){
        Person person = new Person();
        Problem prob1 = new Problem("no money", Type.EDUCATION);
        Problem prob2 = new Problem("FOOD", Type.FINANCIAL);
        person.add(prob1);
        person.add(prob2);
        String expected = """
                no money -> EDUCATION
                FOOD -> FINANCIAL
                """;
        assertEquals(expected, person.reCountProblems());
    }
    @Test
    void testProblems_isSolved(){
        Person person = new Person();
        Problem prob1 = new Problem("no money", Type.EDUCATION);
        person.add(prob1);
        String expected = """
                no money -> EDUCATION
                """;
        assertEquals(expected, person.reCountProblems());
        assertFalse(person.isSolved(prob1));
        assertEquals(expected, person.reCountProblems());
    }
    @Test
    void testCheck_ifProblemIsSolved(){
        Person person = new Person();
        Problem prob1 = new Problem("no money", Type.EDUCATION);
        person.add(prob1);
        assertFalse(person.isSolved(prob1));

    }

}
