package pl.paweln.dp.behavioral.command;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CommandTest {
    private static Logger logger = LoggerFactory.getLogger(CommandTest.class);
    @Test
    public void testBankAccount() {

        BankAccount ba = new BankAccount();
        logger.info(ba.toString());

        List<Command> commands = Arrays.asList(
                new BankAccountCommand(ba, BankAccountCommand.Action.DEPOSIT, 100),
                new BankAccountCommand(ba, BankAccountCommand.Action.WITHDRAW, 1000)
        );

        for (Command c : commands) {
            c.call();
        }

        Assert.assertEquals(100, ba.getBalance());
        logger.info(ba.toString());

    }

    @Test
    public void testBankAccountWithUndo() {

        BankAccount ba = new BankAccount();
        logger.info(ba.toString());

        List<Command> commands = Arrays.asList(
                new BankAccountCommand(ba, BankAccountCommand.Action.DEPOSIT, 100),
                new BankAccountCommand(ba, BankAccountCommand.Action.WITHDRAW, 1000)
        );

        for (Command c : commands) {
            c.call();
        }
        Collections.reverse(commands);

        for(Command c: commands) {
            c.undo();
        }

        Assert.assertEquals(0, ba.getBalance());
        logger.info(ba.toString());
    }
}
