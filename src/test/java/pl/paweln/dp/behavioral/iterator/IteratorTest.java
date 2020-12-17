package pl.paweln.dp.behavioral.iterator;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.paweln.dp.behavioral.iterator.array.Creature;
import pl.paweln.dp.behavioral.iterator.tree.BinaryTree;
import pl.paweln.dp.behavioral.iterator.tree.InOrderIterator;
import pl.paweln.dp.behavioral.iterator.tree.Node;

import java.util.Iterator;
import java.util.Spliterators;
import java.util.stream.StreamSupport;

@SuppressWarnings("ALL")
public class IteratorTest {
    private final static Logger logger = LoggerFactory.getLogger(IteratorTest.class);
    @Test
    public void testInOrderIterator() {
        //   1
        //  / \
        // 2   3
        // output 213

        logger.info("Inorder iterator test ...");
        Node<Integer> root = new Node<>(1, new Node(2), new Node<>(3));
        InOrderIterator<Integer> iterator = new InOrderIterator<>(root);

        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
        }

        logger.info("Iterator InOrder: " + sb.toString());
        Assert.assertEquals("213", sb.toString());
    }

    @Test
    public void testPreOrderIterator() {
        //   1
        //  / \
        // 2   3
        // output 213

        logger.info("Preorder iterator test ...");
        Node<Integer> root = new Node<>(1, new Node(2), new Node<>(3));
        Iterator<Node<Integer>> iterator = root.preOrder();

        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            sb.append(iterator.next().value);
        }

        logger.info("Iterator PreOrder: " + sb.toString());
        Assert.assertEquals("123", sb.toString());
    }

    @Test
    public void binaryTreeTest() {
        logger.info("Binary Tree iterator test ...");

        Node<Integer> root = new Node<>(1, new Node(2), new Node<>(3));
        BinaryTree<Integer> tree = new BinaryTree<>(root);

        StringBuilder sb = new StringBuilder();
        for (int i : tree) {
            sb.append(i);
        }
        Assert.assertEquals("213", sb.toString());
    }

    @Test
    public void testArrayBackedIterator() {
        logger.info("Array-Backed iterator test ...");

        Creature creature = new Creature();
        creature.setAgility(10);
        creature.setIntelligence(15);
        creature.setStrength(20);

        Assert.assertEquals(20, creature.max());
        Assert.assertEquals(45, creature.sum());
        Assert.assertEquals(15, (int)creature.avg());

        Assert.assertEquals(3,
                StreamSupport.stream(
                        Spliterators.spliteratorUnknownSize(creature.iterator(), 0),
                        false).count());

    }


}
