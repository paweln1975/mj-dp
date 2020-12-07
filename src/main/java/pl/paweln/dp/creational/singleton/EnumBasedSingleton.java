package pl.paweln.dp.creational.singleton;

// fields are not serialized for Enum
public enum EnumBasedSingleton {
    INSTANCE;
    EnumBasedSingleton() {}
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
