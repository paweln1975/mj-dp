package pl.paweln.dp.behavioral.chainofresponsibility;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.paweln.dp.behavioral.chainofresponsibility.methodchain.*;

public class MethodChainTest {
    private static Logger logger = LoggerFactory.getLogger(MethodChainTest.class);

    @Test
    public void testSimpleMethodChain() {
        logger.info("Chain of responsibility: method chain test ... ");
        Creature goblin = new Creature("Goblin", 2, 2);
        CreatureModifier root = new CreatureModifier(goblin);
        root.add(new DoubleAttackModifier(goblin));
        root.add(new IncreaseDefenceModifier(goblin));
        root.handle();

        Assert.assertEquals(4, goblin.getAttack());
        Assert.assertEquals(5, goblin.getDefence());

        logger.info(goblin.toString());
    }

    @Test
    public void testMethodChainWithChainBreak() {
        logger.info("Chain of responsibility: method chain with break test ... ");
        Creature goblin = new Creature("Goblin", 2, 2);
        CreatureModifier root = new CreatureModifier(goblin);

        root.add(new NoBonusesModifier(goblin));
        root.add(new DoubleAttackModifier(goblin));
        root.add(new IncreaseDefenceModifier(goblin));
        root.handle();

        Assert.assertEquals(2, goblin.getAttack());
        Assert.assertEquals(2, goblin.getDefence());

        logger.info(goblin.toString());
    }
}
