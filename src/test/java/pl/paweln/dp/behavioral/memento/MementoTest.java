package pl.paweln.dp.behavioral.memento;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MementoTest {
    private static final Logger logger = LoggerFactory.getLogger(MementoTest.class);

    @Test
    public void testMemento() {
        logger.info("Starting Memento test ...");
        BankAccount bankAccount = new BankAccount(100);

        BankAccountToken token1 = bankAccount.deposit(50);
        BankAccountToken token2 = bankAccount.deposit(25);

        Assert.assertEquals(175, bankAccount.getBalance());

        bankAccount.restore(token1);
        Assert.assertEquals(150, bankAccount.getBalance());

        bankAccount.restore(token2);
        Assert.assertEquals(175, bankAccount.getBalance());

    }
}
