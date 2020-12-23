package pl.paweln.dp.behavioral.nullobject;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class NullObjectTest {
    private static final Logger logger = LoggerFactory.getLogger(NullObjectTest.class);

    @Test
    public void testNullObject() {
        logger.info("Starting Null Object test ...");
        BankAccount bankAccount = new BankAccount(new OutputLog());
        bankAccount.deposit(100);
        Assert.assertEquals(100, bankAccount.getBalance());

        bankAccount = new BankAccount(new NullLog());
        bankAccount.deposit(200);
        Assert.assertEquals(200, bankAccount.getBalance());
    }

    @Test
    public void testDynamicNullObject() {
        logger.info("Starting Dynamic Null Object test ...");
        BankAccount bankAccount = new BankAccount(DynamicNullObject.noOp(Log.class));
        bankAccount.deposit(500);
        Assert.assertEquals(500, bankAccount.getBalance());
    }
}
