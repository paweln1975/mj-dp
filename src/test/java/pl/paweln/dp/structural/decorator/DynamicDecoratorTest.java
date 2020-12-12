package pl.paweln.dp.structural.decorator;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.paweln.dp.structural.decorator.dynamiccomposition.Circle;
import pl.paweln.dp.structural.decorator.dynamiccomposition.ColoredShape;
import pl.paweln.dp.structural.decorator.dynamiccomposition.TransparentShape;

public class DynamicDecoratorTest {
    private static Logger logger = LoggerFactory.getLogger(DynamicDecoratorTest.class);

    @Test
    public void testCompositeShare() {
        logger.info("Dynamic decorator test ...");
        TransparentShape shape = new TransparentShape(
                new ColoredShape(
                        new Circle(10), "red"
                ), 50
        );

        String expected = "A circle of a radius 10.0 has the color red has transparency of 50%";

        logger.info("New decorated shape: " + shape.info());
        Assert.assertEquals(expected, shape.info());

        ColoredShape shapeColored = new ColoredShape(new Circle(15), "green");

        expected = "A circle of a radius 15.0 has the color green";
        logger.info("New decorated shape: " + shapeColored.info());
        Assert.assertEquals(expected, shapeColored.info());
    }
}
