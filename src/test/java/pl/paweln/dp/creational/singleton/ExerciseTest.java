package pl.paweln.dp.creational.singleton;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.paweln.dp.creational.singleton.exercise.SingletonTester;

import java.util.function.Supplier;

public class ExerciseTest {
    private static final Logger logger = LoggerFactory.getLogger(ExerciseTest.class);

    @Test
    public void testSingletonTesterWithNonSingleton() {
        Supplier<Object> supplier = () -> 10;
        Assert.assertFalse(SingletonTester.isSingleton(supplier));
    }

    @Test
    public void testSingletonTesterWithSingleton() {
        Supplier<Object> supplier = BasicSingleton::getInstance;
        Assert.assertTrue(SingletonTester.isSingleton(supplier));
    }
}
