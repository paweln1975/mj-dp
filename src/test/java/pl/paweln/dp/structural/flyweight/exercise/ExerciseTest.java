package pl.paweln.dp.structural.flyweight.exercise;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.paweln.dp.structural.flyweight.FormattedTextTest;
import pl.paweln.dp.structural.flyweight.exercise.Sentence;

public class ExerciseTest {
    private static Logger logger = LoggerFactory.getLogger(FormattedTextTest.class);

    @Test
    public void testSentence() {
        String s = "hello world";
        String expected = "hello WORLD";
        Sentence sentence = new Sentence(s);
        sentence.getWord(1).capitalize = true;

        Assert.assertEquals(expected, sentence.toString());
    }
}
