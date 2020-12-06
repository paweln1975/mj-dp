package pl.paweln.dp.creational.factory;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.paweln.dp.creational.factory.abstractfactory.DrinkType;
import pl.paweln.dp.creational.factory.abstractfactory.HotDrink;
import pl.paweln.dp.creational.factory.abstractfactory.HotDrinkMachine;

public class AbstractFactoryTest {
    private static final Logger logger = LoggerFactory.getLogger(AbstractFactoryTest.class);

    HotDrinkMachine machine = new HotDrinkMachine();

    @Test
    public void testDrinks() {
        logger.info("Abstract Factory test ...");
        int amount = 200;
        DrinkType type = DrinkType.COFFEE;
        HotDrink drink = machine.makeDrink(type, amount);
        String expected = "This is "+amount+"ml of coffee.";

        logger.info(drink.consume());
        Assert.assertEquals(expected, drink.consume());

        amount = 300;
        type = DrinkType.TEE;
        drink = machine.makeDrink(type, amount);
        expected = "This is "+amount+"ml of tea.";

        logger.info(drink.consume());
        Assert.assertEquals(expected, drink.consume());
    }
}
