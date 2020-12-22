package pl.paweln.dp.behavioral.nullobject;

import org.junit.Assert;
import org.junit.Test;

public class NullObjectTest {
    @Test
    public void testNullObject() {
        BankAccount bankAccount = new BankAccount(new OutputLog());
        bankAccount.deposit(100);
        Assert.assertEquals(100, bankAccount.getBalance());

        bankAccount = new BankAccount(new NullLog());
        bankAccount.deposit(200);
        Assert.assertEquals(200, bankAccount.getBalance());
    }

    @Test
    public void testDynamicNullObject() {
        BankAccount bankAccount = new BankAccount(DynamicNullObject.noOp(Log.class));
        bankAccount.deposit(500);
        Assert.assertEquals(500, bankAccount.getBalance());
    }
}
