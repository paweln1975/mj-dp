package pl.paweln.dp.creational.factory.exercise;

public class PersonFactory {
    private int count = -1;
    public Person createPerson(String name)
    {
        count++;
        return new Person(count, name);
    }
}
