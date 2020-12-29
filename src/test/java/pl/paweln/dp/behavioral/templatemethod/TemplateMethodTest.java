package pl.paweln.dp.behavioral.templatemethod;

import org.junit.Assert;
import org.junit.Test;

public class TemplateMethodTest {
    @Test
    public void testTemplateMethod() {
        Game game = new Chess();
        game.run();
        Assert.assertEquals(0, game.getWinningPlayer());
    }
}
