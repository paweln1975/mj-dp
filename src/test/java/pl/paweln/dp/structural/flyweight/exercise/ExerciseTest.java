package pl.paweln.dp.structural.flyweight.exercise;

import org.junit.Assert;
import org.junit.Test;

public class ExerciseTest {

    @Test
    public void testSentence() {
        String s = "hello world";
        String expected = "hello WORLD";
        Sentence sentence = new Sentence(s);
        sentence.getWord(1).capitalize = true;

        Assert.assertEquals(expected, sentence.toString());
    }
}
