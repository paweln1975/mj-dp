package pl.paweln.dp.behavioral.observer.event;

public class Person {
    public final Event<PropertyChangeEventArgs> propertyChange =
            new Event<>();
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (this.age == age) return;
        this.age = age;
        propertyChange.fire(
                new PropertyChangeEventArgs(this, "age", this.age));
    }
}
