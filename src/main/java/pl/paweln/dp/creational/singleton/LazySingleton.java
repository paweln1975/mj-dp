package pl.paweln.dp.creational.singleton;

public class LazySingleton {
    private static LazySingleton instance;
    private int value;

    private LazySingleton() {}

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static LazySingleton getInstance() {
        // double check locking
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                    instance.value++;
                }
            }
        }

        return instance;
    }
}
