package pl.paweln.dp.creational.builder.faceted;

public class PersonAddressBuilder extends PersonBuilder {
    public PersonAddressBuilder(Person person) {
        this.person = person;
    }

    public PersonAddressBuilder at (String streetAddress) {
        this.person.setStreetAddress(streetAddress);
        return this;
    }

    public PersonAddressBuilder withPostCode (String postalCode) {
        this.person.setPostalCode(postalCode);
        return this;
    }

    public PersonAddressBuilder in (String city) {
        this.person.setCity(city);
        return this;
    }
}
