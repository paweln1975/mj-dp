package pl.paweln.dp.structural.decorator;

import org.junit.Assert;
import org.junit.Test;

public class MagicStringTest {
    @Test
    public void testMagicString() {
        MagicString ms = new MagicString("Pawel Niedziela");
        Assert.assertEquals(7, ms.getNumberOfVowels());
    }
}
