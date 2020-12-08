package pl.paweln.dp.structural.composite;

import org.junit.Assert;
import org.junit.Test;
import pl.paweln.dp.structural.composite.arithmetic.ArithmeticComposite;
import pl.paweln.dp.structural.composite.arithmetic.MinusOperand;
import pl.paweln.dp.structural.composite.arithmetic.NumericValue;
import pl.paweln.dp.structural.composite.arithmetic.PlusOperand;

public class ArithmeticCompositeTest {
    @Test
    public void testArithmeticCompositeTest() {
        ArithmeticComposite expr = new MinusOperand(
                new PlusOperand(new NumericValue(5), new NumericValue(7)),
                new NumericValue(2));

        Assert.assertEquals(10, expr.getValue());
    }
}
