package pl.paweln.dp.behavioral.chainofresponsibility;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.paweln.dp.behavioral.chainofresponsibility.brokerchain.Creature;
import pl.paweln.dp.behavioral.chainofresponsibility.brokerchain.DoubleAttackModifier;
import pl.paweln.dp.behavioral.chainofresponsibility.brokerchain.Game;
import pl.paweln.dp.behavioral.chainofresponsibility.brokerchain.IncreaseDefenceModifier;


public class BrokerChainTest {
    private static Logger logger = LoggerFactory.getLogger(BrokerChainTest.class);

    @Test
    public void testBrokerChain() {
        logger.info("Chain of responsibility: broker chain test ... ");
        Game game = new Game();
        Creature goblin = new Creature(game,"Strong Goblin", 2, 2);

        Assert.assertEquals(2, goblin.getAttack());
        Assert.assertEquals(2, goblin.getDefence());
        logger.info(goblin.toString());

        new IncreaseDefenceModifier(game, goblin);

        Assert.assertEquals(2, goblin.getAttack());
        Assert.assertEquals(5, goblin.getDefence());
        logger.info(goblin.toString());

        try (DoubleAttackModifier dam = new DoubleAttackModifier(game, goblin)) {
            Assert.assertEquals(4, goblin.getAttack());
            Assert.assertEquals(5, goblin.getDefence());

            logger.info(goblin.toString());
        }

        Assert.assertEquals(2, goblin.getAttack());
        Assert.assertEquals(5, goblin.getDefence());

        logger.info(goblin.toString());
    }
}
