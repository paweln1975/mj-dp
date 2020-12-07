package pl.paweln.dp.creational.singleton;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingletonTest {
    private static final Logger logger = LoggerFactory.getLogger(SingletonTest.class);


    @Test
    public void testSingletonSerialization() throws Exception {
        int value = 111;

        logger.info("Basic Singleton test ...");
        BasicSingleton singleton = BasicSingleton.getInstance();
        singleton.setValue(value);

        String filename = "singleton.bin";

        ClassSerializationUtil<BasicSingleton> util = new ClassSerializationUtil<>();

        util.saveToFile(singleton, filename);

        singleton.setValue(value + 100);

        BasicSingleton singleton2 = util.readFromFile(filename);

        logger.info("References equals?: " + (singleton == singleton2));
        Assert.assertSame(singleton, singleton2);
        logger.info("Value: " + singleton.getValue());
        logger.info("Value: " + singleton2.getValue());
        Assert.assertEquals(singleton.getValue(), singleton2.getValue());
    }

    @Test
    public void testLazySingleton() throws Exception {
        logger.info("Lazy Singleton test ...");

        final LazySingleton[] lazySingleton = new LazySingleton[1];

        Runnable runnable;
        runnable = () -> lazySingleton[0] = LazySingleton.getInstance();

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();

        Thread.sleep(100);

        logger.info("Value from singleton: " + lazySingleton[0].getValue());

        Assert.assertEquals(1, lazySingleton[0].getValue());
    }

    @Test
    public void testInnerStaticSingleton() throws Exception {
        logger.info("Inner Static Singleton test ...");

        InnerStaticSingleton innerStaticSingleton1 = InnerStaticSingleton.getInstance();
        innerStaticSingleton1.setValue(100);

        String filename = "singleton.bin";

        ClassSerializationUtil<InnerStaticSingleton> util = new ClassSerializationUtil<>();
        util.saveToFile(innerStaticSingleton1, filename);

        innerStaticSingleton1.setValue(200);

        InnerStaticSingleton innerStaticSingleton2 = util.readFromFile(filename);

        Assert.assertSame(innerStaticSingleton1, innerStaticSingleton2);


    }

    @Test
    public void testEnumBasedSingleton() {
        logger.info("Enum Static Singleton test ...");
        EnumBasedSingleton enumBasedSingleton = EnumBasedSingleton.INSTANCE;
        int value = 100;
        enumBasedSingleton.setValue(value);

        Assert.assertEquals(value, enumBasedSingleton.getValue());

    }
}