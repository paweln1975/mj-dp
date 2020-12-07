package pl.paweln.dp.creational.singleton.exercise;

import java.util.function.Supplier;

public class SingletonTester {
    public static boolean isSingleton(Supplier<Object> func)
    {
        Object obj = func.get();
        Object obj2 = func.get();

        return obj == obj2;
    }
}
