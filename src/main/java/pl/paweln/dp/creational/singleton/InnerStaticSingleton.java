package pl.paweln.dp.creational.singleton;

import java.io.Serializable;

// no need of synchronization, it's thread safe
public class InnerStaticSingleton implements Serializable {
    private InnerStaticSingleton() {}

    private static class Impl implements Serializable {
        private static final InnerStaticSingleton
            INSTANCE = new InnerStaticSingleton();
    }

    protected Object readResolve()
    {
        return Impl.INSTANCE;
    }

    public static InnerStaticSingleton getInstance() {
        return Impl.INSTANCE;
    }

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
