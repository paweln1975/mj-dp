package pl.paweln.dp.structural.proxy;

import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.paweln.dp.structural.proxy.propertyproxy.Creature;

public class PropertyProxyTest {
    private static Logger logger = LoggerFactory.getLogger(PropertyProxyTest.class);

    @Test
    public void testProtectionProxy() {
        logger.info("Protection proxy test ...");
        int agility = 50;
        Creature creature = new Creature("Dragon");
        creature.setAgility(agility);

        Assert.assertEquals(agility, creature.getAgility());
    }
}
