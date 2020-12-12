package pl.paweln.dp.structural.flyweight;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FormattedTextTest {
    private static Logger logger = LoggerFactory.getLogger(FormattedTextTest.class);

    @Test
    public void testFormattedText() {

        FormattedText ft = new FormattedText("This is a brave new world.");
        String expected = "This is a BRAVE new world.";
        FormattedText.TextRange range = ft.getRange(10, 15);
        range.capitalize = true;

        Assert.assertEquals(expected, ft.toString());
    }
}
