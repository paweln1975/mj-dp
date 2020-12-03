package pl.paweln.dp.creational.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.paweln.dp.specification.Specification;

public class BuilderDemo {
    private static final Logger logger = LoggerFactory.getLogger(BuilderDemo.class);

    public static void demo() {
        HtmlBuilder builder = new HtmlBuilder("ul");
        builder.addChild("li", "Pawel");
        builder.addChild("li", "Emilka");

        logger.info("Builder demo ...");
        logger.info(" Html element:" + builder.toString());

    }
}
