package pl.paweln.dp.behavioral.memento.exercise;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

public class ExerciseTest {
    private static final Logger logger = LoggerFactory.getLogger(ExerciseTest.class);

    @Test
    public void singleTokenTest()
    {
        TokenMachine tm = new TokenMachine();
        Memento m = tm.addToken(123);
        tm.addToken(456);
        tm.revert(m);

        assertEquals(1,  tm.tokens.size());
        assertEquals(123, tm.tokens.get(0).value);
    }

    @Test
    public void twoTokenTest()
    {
        TokenMachine tm = new TokenMachine();
        tm.addToken(1);
        Memento m = tm.addToken(2);
        tm.addToken(3);
        tm.revert(m);
        assertEquals(2, tm.tokens.size());
        assertEquals("First token should have value 1",
                1, tm.tokens.get(0).value);
        assertEquals(2, tm.tokens.get(1).value);
    }

    @Test
    public void fiddledTokenTest()
    {
        TokenMachine tm = new TokenMachine();
        logger.info("Made a token with value 111 and kept a reference");
        Token token = new Token(111);
        logger.info("Added this token to the list");
        tm.addToken(token);
        Memento m = tm.addToken(222);
        logger.info("Changed this token's value to 333 :)");
        token.value = 333;
        tm.revert(m);

        assertEquals(
                "At this point, token machine should have exactly two tokens, "
                        + "but you got " + tm.tokens.size(),
                2, tm.tokens.size()
        );

        assertEquals("You got the token value wrong here. " +
                        "Hint: did you init the memento by value?",
                111, tm.tokens.get(0).value);
    }
}
