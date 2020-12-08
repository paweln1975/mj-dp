package pl.paweln.dp.creational.singleton.multiton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Printer {
    private static final Logger logger = LoggerFactory.getLogger(Printer.class);
    private static int instanceCount = 0;

    private Printer()
    {
        instanceCount++;
        logger.info("A total of " + instanceCount + " printer instances created so far.");
    }

    public static int getInstanceCount() {
        return instanceCount;
    }

    private static final Map<Subsystem, Printer>
            instances = new HashMap<>();

    public static Printer get(Subsystem ss)
    {
        if (!instances.containsKey(ss)) {
            synchronized (Printer.class) {
                if (!instances.containsKey(ss)) {
                    @SuppressWarnings("InstantiationOfUtilityClass")
                    Printer instance = new Printer();
                    instances.put(ss, instance);
                    return instance;
                } else {
                    return instances.get(ss);
                }
            }
        } else {
            return instances.get(ss);
        }

    }
}
