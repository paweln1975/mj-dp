package pl.paweln.dp.creational.singleton;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BasicSingletonTest {
    private static final Logger logger = LoggerFactory.getLogger(BasicSingletonTest.class);

    private static void saveToFile(BasicSingleton singleton, String filename)
            throws Exception
    {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut))
        {
            out.writeObject(singleton);
        }
    }

    private static BasicSingleton readFromFile(String filename)
            throws Exception
    {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn) )
        {
            return (BasicSingleton)in.readObject();
        }
    }
    @Test
    public void testSingletonSerialization() throws Exception {
        int value = 111;

        BasicSingleton singleton = BasicSingleton.getInstance();
        singleton.setValue(value);

        String filename = "singleton.bin";
        saveToFile(singleton, filename);

        singleton.setValue(value + 100);

        BasicSingleton singleton2 = readFromFile(filename);

        logger.info("References equals?: " + (singleton == singleton2));
        Assert.assertSame(singleton, singleton2);
        logger.info("Value: " + singleton.getValue());
        logger.info("Value: " + singleton2.getValue());
        Assert.assertEquals(singleton.getValue(), singleton2.getValue());
    }
}
