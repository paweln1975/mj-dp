package pl.paweln.dp.structural.bridge.exercise;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.paweln.dp.structural.bridge.Renderer;

public class ExerciseTest {
    private static Logger logger = LoggerFactory.getLogger(Renderer.class);

    @Test
    public void testExercise() {
        String expected = "Drawing Triangle as pixels";
        Assert.assertEquals(expected, new Triangle(new RasterRenderer()).toString());

        expected = "Drawing Triangle as lines";
        Assert.assertEquals(expected, new Triangle(new VectorRenderer()).toString());

        expected = "Drawing Square as pixels";
        Assert.assertEquals(expected, new Square(new RasterRenderer()).toString());

        expected = "Drawing Square as lines";
        Assert.assertEquals(expected, new Square(new VectorRenderer()).toString());

    }

}
