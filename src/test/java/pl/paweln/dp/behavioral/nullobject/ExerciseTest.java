package pl.paweln.dp.behavioral.nullobject;

import org.junit.Test;
import pl.paweln.dp.behavioral.nullobject.exercise.Account;
import pl.paweln.dp.behavioral.nullobject.exercise.NullLog;

public class ExerciseTest {
    @Test
    public void   singleCallTest() throws Exception
    {
        Account a = new Account(new NullLog());
        a.someOperation();
    }

    @Test
    public void manyCallsTest() throws Exception
    {
        Account a = new Account(new NullLog());
        for (int i = 0; i < 100; ++i)
            a.someOperation();
    }
}
