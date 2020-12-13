package pl.paweln.dp.structural.proxy.propertyproxy;

public class Creature {
    Property<Integer> agility = new Property<>(10, "agility", this);

    private String name;

    public Creature (String name) {
        this.name = name;
    }

    public int getAgility() {
        return agility.getValue();
    }

    public void setAgility(int value) {
        agility.setValue(value);
    }

    @Override
    public String toString() {
        return "Creature{" +
                "name='" + name + '\'' +
                '}';
    }
}
