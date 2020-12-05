package pl.paweln.dp.creational.builder;

import org.junit.Assert;
import org.junit.Test;
import pl.paweln.dp.creational.builder.faceted.Person;
import pl.paweln.dp.creational.builder.faceted.PersonBuilder;

public class FacetedBuilderTest {
    PersonBuilder personBuilder = new PersonBuilder();

    @Test
    public void builderTest() {
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
                .from(year).build();

        String expected = "Person{streetAddress='"+address+
                "', postalCode='"+code+"', city='"+city+"', companyName='"+company+
                "', position='"+position+"', startYear="+year+"}";
        Assert.assertEquals(expected, person.toString());

    }
}
