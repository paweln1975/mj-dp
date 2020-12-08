package pl.paweln.dp.structural.bridge;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Assert;
import org.junit.Test;

public class BridgeTest {
    @Test
    public void testShapeBridge() {
        Injector injector = Guice.createInjector(new ShapeModule());
        Circle circle = injector.getInstance(Circle.class);
        circle.setRadius(5);
        circle.draw();
        circle.resize(10);
        circle.draw();

        Assert.assertEquals(50, circle.getRadius());
    }
}
