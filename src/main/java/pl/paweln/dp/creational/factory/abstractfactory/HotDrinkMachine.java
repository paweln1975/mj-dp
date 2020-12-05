package pl.paweln.dp.creational.factory.abstractfactory;

public class HotDrinkMachine {
    public HotDrink makeDrink (DrinkType drinkType, int amount) {
        HotDrinkFactory factory = null;
        switch (drinkType) {
            case TEE:
                factory = new TeeFactory();
                break;
            case COFFEE:
                factory = new CoffeeFactory();
                break;
        }
        return factory.prepare(amount);
    }
}
