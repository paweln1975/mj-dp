package pl.paweln.dp.creational.factory.abstractfactory;

public class Tea implements HotDrink {
    private int amount;

    public Tea(int amount) {
        this.amount = amount;
    }

    @Override
    public String consume() {
        return "This is "+amount+"ml of tea.";
    }
}
