package pl.paweln.dp.creational.factory.abstractfactory;

public class Coffee implements HotDrink {
    private int amount;
    public Coffee(int amount) {
        this.amount = amount;
    }

    @Override
    public String consume() {
        return "This is " + amount +"ml of coffee.";
    }
}
