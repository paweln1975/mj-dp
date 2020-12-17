package pl.paweln.dp.behavioral.interpreter;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class InterpreterTest {
    private static Logger logger = LoggerFactory.getLogger(InterpreterTest.class);
    @Test
    public void testInterpreter() {
        logger.info("Interpreter test ...");
        String expr = "(12+3)+(143-1)";
        String expected = "`(`\t`12`\t`+`\t`3`\t`)`\t`+`\t`(`\t`143`\t`-`\t`1`\t`)`";

        List<Token> tokenList= Interpreter.lex(expr);
        String output = tokenList.stream().map(Token::toString).collect(Collectors.joining("\t"));
        Assert.assertEquals(expected, output);

        logger.info(output);

        Element element = Interpreter.parse(tokenList);
        int value = element.eval();

        logger.info("Result: " + expr + " = " + value);
        Assert.assertEquals(157, value);
    }
}
