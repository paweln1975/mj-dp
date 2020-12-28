package pl.paweln.dp.behavioral.nullobject.exercise;

import org.junit.Assert;
import org.junit.Test;

public class ExerciseTest {
    @Test
    public void singleCallTest() throws Exception
    {
        Account a = new Account(new NullLog());
        Assert.assertEquals(1, a.someOperation() );
    }

    @Test
    public void manyCallsTest() throws Exception
    {
        Account a = new Account(new NullLog());
        int lastValue = 0;
        for (int i = 0; i < 100; ++i)
            lastValue = a.someOperation();
        Assert.assertEquals(100, lastValue);
    }
}
