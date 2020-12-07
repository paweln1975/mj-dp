package pl.paweln.dp.creational.singleton;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.paweln.dp.creational.singleton.multiton.Printer;
import pl.paweln.dp.creational.singleton.multiton.Subsystem;

public class MultitonTest {
    private static final Logger logger = LoggerFactory.getLogger(MultitonTest.class);

    @Test
    public void simpleMultitonTest() {
        logger.info("Multiton test ...");
        Printer main = Printer.get(Subsystem.PRIMARY);
        Printer aux = Printer.get(Subsystem.AUXILIARY);
        Printer aux2 = Printer.get(Subsystem.AUXILIARY);
        Printer fall = Printer.get(Subsystem.FALLBACK);

        Assert.assertSame(aux, aux2);
        Assert.assertEquals(3, Printer.getInstanceCount());
    }

}
