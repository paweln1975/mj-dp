package pl.paweln.dp.creational.singleton.exercise;

import org.junit.Assert;
import org.junit.Test;
import pl.paweln.dp.creational.singleton.BasicSingleton;
import java.util.function.Supplier;

public class ExerciseTest {


    @Test
    public void testSingletonTesterWithNonSingleton() {
        Supplier<Object> supplier = Object::new;
        Assert.assertFalse(SingletonTester.isSingleton(supplier));
    }

    @Test
    public void testSingletonTesterWithSingleton() {
        Supplier<Object> supplier = BasicSingleton::getInstance;
        Assert.assertTrue(SingletonTester.isSingleton(supplier));
    }
}
