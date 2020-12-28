package pl.paweln.dp.behavioral.strategy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class StrategyTest {
    private static final Logger logger = LoggerFactory.getLogger(StrategyTest.class);
    private DynamicTextProcessor processor = new DynamicTextProcessor(OutputFormat.HTML);
    String expectedHTML = "<ul>" + System.lineSeparator() +
            " <li>liberty</li>" + System.lineSeparator() +
            " <li>freedom</li>" +System.lineSeparator() +
            " <li>people</li>" +System.lineSeparator() +
            "</ul>" + System.lineSeparator();
    String expectedMarkdown = " * liberty" + System.lineSeparator() +
            " * freedom" +System.lineSeparator() +
            " * people" + System.lineSeparator();

    @Before
    public void setup() {
        processor.clear();
    }

    @Test
    public void testDynamicStrategyHTML() {

        logger.info("Dynamic Strategy HTML test ...");

        processor.setOutputFormat(OutputFormat.HTML);
        processor.appendList(Arrays.asList("liberty", "freedom", "people"));

        logger.info("HTML output" + processor.toString());

        Assert.assertEquals(expectedHTML, processor.toString());

    }

    @Test
    public void testDynamicStrategyMarkdown() {

        logger.info("Dynamic Strategy Markdown test ...");
        processor.setOutputFormat(OutputFormat.MARKDOWN);
        processor.appendList(Arrays.asList("liberty", "freedom", "people"));

        logger.info("HTML output" + processor.toString());

        Assert.assertEquals(expectedMarkdown, processor.toString());
    }

    @Test
    public void testStaticStrategyHTML() {
        logger.info("Dynamic Static HTML test ...");
        StaticTextProcessor<HTMLListStrategy> processor = new
                StaticTextProcessor<>(HTMLListStrategy::new);
        processor.appendList(Arrays.asList("liberty", "freedom", "people"));
        Assert.assertEquals(expectedHTML, processor.toString());
    }

    @Test
    public void testStaticStrategyMarkdown() {
        logger.info("Dynamic Static Markdown test ...");
        StaticTextProcessor<MarkdownListStrategy> processor = new
                StaticTextProcessor<>(MarkdownListStrategy::new);
        processor.appendList(Arrays.asList("liberty", "freedom", "people"));
        Assert.assertEquals(expectedMarkdown, processor.toString());
    }
}
