package pl.paweln.dp.creational.factory;

import org.junit.Assert;
import org.junit.Test;
import pl.paweln.dp.creational.factory.abstractfactory.DrinkType;
import pl.paweln.dp.creational.factory.abstractfactory.HotDrink;
import pl.paweln.dp.creational.factory.abstractfactory.HotDrinkMachine;

public class AbstractFactoryTest {
    HotDrinkMachine machine = new HotDrinkMachine();

    @Test
    public void testDrinks() {
        int amount = 200;
        DrinkType type = DrinkType.COFFEE;
        HotDrink drink = machine.makeDrink(type, amount);
        String expected = "This is "+amount+"ml of coffee.";

        Assert.assertEquals(expected, drink.consume());

        amount = 300;
        type = DrinkType.TEE;
        drink = machine.makeDrink(type, amount);
        expected = "This is "+amount+"ml of tea.";

        Assert.assertEquals(expected, drink.consume());
    }
}
