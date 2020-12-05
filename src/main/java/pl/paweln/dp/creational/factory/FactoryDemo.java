package pl.paweln.dp.creational.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.paweln.dp.creational.factory.abstractfactory.DrinkType;
import pl.paweln.dp.creational.factory.abstractfactory.HotDrink;
import pl.paweln.dp.creational.factory.abstractfactory.HotDrinkMachine;
import pl.paweln.dp.specification.Specification;

public class FactoryDemo {
    private static final Logger logger = LoggerFactory.getLogger(Specification.class);

    public static void demo() {
        logger.info("Factory method demo ...");
        Point point = Point.newCartesianPoint(10, 5);
        logger.info("Point created: " + point);

        Point point1 = Point.newPolarPoint(5, Math.PI/4);
        logger.info("Point created: " + point1);

        logger.info("Abstract Factory demo ...");
        HotDrinkMachine machine = new HotDrinkMachine();
        HotDrink coffee = machine.makeDrink(DrinkType.COFFEE, 200);
        HotDrink tee = machine.makeDrink(DrinkType.TEE, 300);

        logger.info(coffee.consume());;
        logger.info(tee.consume());
    }

}
