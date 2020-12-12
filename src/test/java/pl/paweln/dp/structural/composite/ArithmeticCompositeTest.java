package pl.paweln.dp.structural.composite;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.paweln.dp.structural.composite.arithmetic.ArithmeticComposite;
import pl.paweln.dp.structural.composite.arithmetic.MinusOperand;
import pl.paweln.dp.structural.composite.arithmetic.NumericValue;
import pl.paweln.dp.structural.composite.arithmetic.PlusOperand;

public class ArithmeticCompositeTest {
    private static Logger logger = LoggerFactory.getLogger(ArithmeticCompositeTest.class);
    @Test
    public void testArithmeticCompositeTest() {
        logger.info("Composite with arithmetic test ...");
        ArithmeticComposite expr = new MinusOperand(
                new PlusOperand(new NumericValue(5), new NumericValue(7)),
                new NumericValue(2));

        Assert.assertEquals(10, expr.getValue());
    }
}
