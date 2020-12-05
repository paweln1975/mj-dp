package pl.paweln.dp.creational.factory.abstractfactory;

public class TeeFactory implements HotDrinkFactory {
    @Override
    public HotDrink prepare(int amount) {
        return new Tea(amount);
    }
}
