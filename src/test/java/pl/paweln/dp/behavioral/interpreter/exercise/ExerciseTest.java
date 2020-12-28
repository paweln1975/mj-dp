package pl.paweln.dp.behavioral.interpreter.exercise;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExerciseTest {
    @Test
    public void testExercise() {
        ExpressionProcessor ep = new ExpressionProcessor();
        ep.variables.put('x', 5);
        ep.variables.put('y', 10);

        assertEquals(1, ep.calculate("1"));
        assertEquals(3, ep.calculate("1+2"));
        assertEquals(6, ep.calculate("1+x"));
        assertEquals(0, ep.calculate("1+xy"));
        assertEquals(5, ep.calculate("10-20+10+5"));

        assertEquals(15, ep.calculate("x+y"));
        assertEquals(13, ep.calculate("x+y-10+3+x"));
    }
}
