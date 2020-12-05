package pl.paweln.dp.creational.builder;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BuilderTest {
    HtmlBuilder builder = new HtmlBuilder("root");

    @Before
    public void setup() {

    }

    @After
    public void clear() {
        this.builder.clear();
    }

    @Test
    public void testHtmlBuilder() {
        String mainText = "Main text";
        String bodyText = "Main text";

        builder.addChild("html", mainText);
        builder.addChild("body", bodyText);

        String nL = System.lineSeparator();
        String expected = "<root>" + nL +
                "  <html>" + nL +
                "    " + mainText + nL +
                "  </html>" + nL +
                "  <body>" + nL +
                "    " + bodyText + nL +
                "  </body>" + nL +
                "</root>" + nL;

        Assert.assertEquals(expected, builder.toString());
    }
}
