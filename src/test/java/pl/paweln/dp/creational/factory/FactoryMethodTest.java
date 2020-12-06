package pl.paweln.dp.creational.factory;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FactoryMethodTest {
    private static final Logger logger = LoggerFactory.getLogger(FactoryMethodTest.class);

    @Test
    public void testFactoryMethod() {
        logger.info("Factory method demo ...");
        int x = 10, y = 5;
        Point point = Point.newCartesianPoint(x,y);
        logger.info("Point created: " + point);

        Assert.assertEquals(x, (int)point.getX());

        Point point1 = Point.newPolarPoint(5, Math.PI/4);
        logger.info("Point created: " + point1);
    }
}
