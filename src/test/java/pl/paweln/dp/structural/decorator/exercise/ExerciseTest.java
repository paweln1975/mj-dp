package pl.paweln.dp.structural.decorator.exercise;


import org.junit.Assert;
import org.junit.Test;

public class ExerciseTest {
    @Test
    public void testExercise() {
        Dragon dragon = new Dragon();

        Assert.assertEquals("flying", dragon.fly());
        Assert.assertEquals("too young", dragon.crawl());

        dragon.setAge(20);

        Assert.assertEquals("too old", dragon.fly());
        Assert.assertEquals("crawling", dragon.crawl());

    }
}
