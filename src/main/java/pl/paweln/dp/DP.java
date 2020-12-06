package pl.paweln.dp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.paweln.dp.creational.builder.BuilderDemo;
import pl.paweln.dp.creational.factory.FactoryDemo;
import pl.paweln.dp.creational.prototype.PrototypeDemo;
import pl.paweln.dp.specification.SpecificationDemo;

public class DP {
    private static final Logger logger = LoggerFactory.getLogger(DP.class);
    public static void main(String[] args) {
        logger.info("Starting ...");
        SpecificationDemo.demo();
        BuilderDemo.demo();
        FactoryDemo.demo();
        PrototypeDemo.demo();

        logger.info("End.");
    }

}
