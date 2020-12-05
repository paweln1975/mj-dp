package pl.paweln.dp.creational.builder.faceted;

public class PersonBuilder {
    protected Person person = new Person();

    public Person build() {
        return this.person;
    }

    public PersonAddressBuilder lives() {
        return new PersonAddressBuilder(this.person);
    }

    public PersonJobBuilder works() {
        return new PersonJobBuilder(this.person);
    }
}
