package pl.paweln.dp.structural.proxy.exercise;

public class ResponsiblePerson {
    private Person person;

    public ResponsiblePerson(Person person)
    {
        this.person = person;
    }

    public void setAge (int age) {
        this.person.setAge(age);
    }

    public String drink() {
        if (this.person.getAge() < 18) {
            return "too young";
        } else {
        return this.person.drink();
        }
    }
    public String drive() {
        if (this.person.getAge() < 16) {
            return "too young";
        } else {
            return this.person.drive();
        }
    }
    public String drinkAndDrive() { return "dead"; }
}
