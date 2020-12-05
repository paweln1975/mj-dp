package pl.paweln.dp.creational.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.paweln.dp.creational.builder.faceted.Person;
import pl.paweln.dp.creational.builder.faceted.PersonBuilder;
import pl.paweln.dp.creational.builder.recursivegenerics.FluentPerson;

public class BuilderDemo {
    private static final Logger logger = LoggerFactory.getLogger(BuilderDemo.class);

    public static void demo() {
        logger.info("Simple Builder demo ...");

        HtmlBuilder builder = new HtmlBuilder("ul");
        builder.addChild("li", "Pawel");
        builder.addChild("li", "Emilka");

        logger.info(" Html element:" + builder.toString());

        logger.info("Recursive Generics Builder Demo demo ...");

        FluentPerson.PersonBuilder builder1 = new FluentPerson.PersonBuilder<>();
        FluentPerson fluentPerson = builder1
                .withName("Monika")
                .atAge(46)
                .build();
        logger.info("Created person: " + fluentPerson);

        FluentPerson.EmployeeBuilder builder2 = new FluentPerson.EmployeeBuilder();
        fluentPerson = builder2
                .withName("John")
                .atAge(46)
                .worksAs("Manager")
                .build();

        logger.info("Created person: " + fluentPerson);

        logger.info("Faceted Builder demo ...");
        PersonBuilder personBuilder = new PersonBuilder();
        Person person = personBuilder
                .lives()
                    .at("Fiolkowa")
                    .withPostCode("30-725")
                    .in("Warszawa")
                .works()
                    .at("Ubisoft")
                    .as("Developer")
                    .from(2000).build();

        logger.info("Created person: " + person);


    }
}
