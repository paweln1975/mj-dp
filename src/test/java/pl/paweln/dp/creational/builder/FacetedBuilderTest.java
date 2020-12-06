package pl.paweln.dp.creational.builder;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.paweln.dp.creational.builder.faceted.Person;
import pl.paweln.dp.creational.builder.faceted.PersonBuilder;

public class FacetedBuilderTest {
    private static final Logger logger = LoggerFactory.getLogger(FacetedBuilderTest.class);
    PersonBuilder personBuilder = new PersonBuilder();

    @Test
    public void builderTest() {
        logger.info("Faceted Builder demo ...");

        String address = "Fiolkowa";
        String code = "30-725";
        String city = "Warsaw";
        String company = "Ubisoft";
        String position = "Developer";
        int year = 2000;

        Person person = personBuilder
                .lives()
                    .at(address)
                    .withPostCode(code)
                    .in(city)
                .works()
                    .at(company)
                    .as(position)
                    .from(year)
                .build();

        String expected = "Person{streetAddress='"+address+
                "', postalCode='"+code+"', city='"+city+"', companyName='"+company+
                "', position='"+position+"', startYear="+year+"}";

        logger.info("Person: " + person);
        Assert.assertEquals(expected, person.toString());

    }
}
