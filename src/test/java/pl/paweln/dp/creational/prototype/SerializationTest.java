package pl.paweln.dp.creational.prototype;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.paweln.dp.creational.prototype.copyconstructor.Address;
import pl.paweln.dp.creational.prototype.serialization.Company;

public class SerializationTest {
    private static final Logger logger = LoggerFactory.getLogger(SerializationTest.class);

    @Test
    public void testSerialization() {
        String companyName = "Coca-cola";
        String companyNameChanged = "Pepsi";

        String streetAddress = "Butcher's road";
        String streetAddressChanged = "Greengrocer's road";
        String postalCode = "99555";
        String city = "Chicago";

        Company company = new Company(companyName, new Address(streetAddress, postalCode, city));

        Company newCompany = SerializationUtils.roundtrip(company);
        newCompany.setName(companyNameChanged);
        newCompany.getAddress().setStreetName(streetAddressChanged);

        logger.info("Company: " + company);
        Assert.assertEquals(companyName, company.getName());
        Assert.assertEquals(streetAddress, company.getAddress().getStreetName());

        logger.info("New company: " + newCompany);
        Assert.assertEquals(companyNameChanged, newCompany.getName());
        Assert.assertEquals(streetAddressChanged, newCompany.getAddress().getStreetName());

    }
}
