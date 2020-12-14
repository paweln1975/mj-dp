package pl.paweln.dp.structural.bridge;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BridgeTest {
    private static Logger logger = LoggerFactory.getLogger(BridgeTest.class);
    @Test
    public void testShapeBridge() {
        logger.info("Bridge test ...");
        Injector injector = Guice.createInjector(new ShapeModule());
        Circle circle = injector.getInstance(Circle.class);
        circle.setRadius(5);
        circle.draw();
        circle.resize(10);
        circle.draw();

        Assert.assertEquals(50, circle.getRadius());
    }
}
