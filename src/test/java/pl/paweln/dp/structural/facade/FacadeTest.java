package pl.paweln.dp.structural.facade;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.paweln.dp.structural.decorator.DynamicDecoratorTest;

public class FacadeTest {
    private static Logger logger = LoggerFactory.getLogger(FacadeTest.class);
    @Test
    public void testConsole() {
        logger.info("Facade test ...");
        Console console = Console.newConsole(30, 20);
        Assert.assertTrue(console.render());
    }
}
