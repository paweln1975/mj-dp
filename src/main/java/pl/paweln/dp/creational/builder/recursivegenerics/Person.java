package pl.paweln.dp.creational.builder.recursivegenerics;

public class Person {
    private String name;
    private int age;
    private String position;

    private Person() {}

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public static class PersonBuilder <SELF extends PersonBuilder<SELF>>
    {
        protected Person person = new Person();

        public SELF withName(String name) {
            person.setName(name);
            return self();
        }

        public SELF atAge(int age) {
            this.person.setAge(age);
            return self();
        }

        @SuppressWarnings("unchecked")
        protected SELF self() {
            return (SELF) this;
        }

        public Person build() {
            return this.person;
        }
    }

    public static class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {
        public EmployeeBuilder worksAs (String position) {
            this.person.setPosition(position);
            return this;
        }

        @Override
        protected EmployeeBuilder self() {
            return super.self();
        }
    }
}
