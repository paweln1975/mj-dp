package pl.paweln.dp.structural.decorator;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MagicStringTest {
    private static Logger logger = LoggerFactory.getLogger(MagicStringTest.class);
    @Test
    public void testMagicString() {
        logger.info("Decorator test ...");
        MagicString ms = new MagicString("Pawel Niedziela");
        Assert.assertEquals(7, ms.getNumberOfVowels());
    }
}
