package pl.paweln.dp.creational.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class BasicSingleton implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(BasicSingleton.class);

    private BasicSingleton() {
        logger.info ("Singleton is initializing");
    }

    private static final BasicSingleton INSTANCE = new BasicSingleton();

    private int value = 0;

    public int getValue()
    {
        return value;
    }
    public void setValue(int value)
    {
        this.value = value;
    }

    public static BasicSingleton getInstance()
    {
        return INSTANCE;
    }

    protected Object readResolve()
    {
        return INSTANCE;
    }
}
