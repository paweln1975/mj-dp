package pl.paweln.dp.structural.bridge.exercise;

import org.junit.Assert;
import org.junit.Test;


public class ExerciseTest {

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
