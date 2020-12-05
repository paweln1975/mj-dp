package pl.paweln.dp.creational.builder.faceted;

public class PersonJobBuilder extends PersonBuilder {
    public PersonJobBuilder(Person person) {
        this.person = person;
    }

    public PersonJobBuilder at (String companyName) {
        this.person.setCompanyName(companyName);
        return this;
    }

    public PersonJobBuilder as (String posittion) {
        this.person.setPosition(posittion);
        return this;
    }

    public PersonJobBuilder from (int year) {
        this.person.setStartYear(year);
        return this;
    }
}
