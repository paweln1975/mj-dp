package pl.paweln.dp.creational.prototype.copyconstructor;

public class Employee {
    private Address address;
    private String name;

    public Employee(Address address, String name) {
        this.address = address;
        this.name = name;
    }

    public Employee (Employee employee) {
        this.name = employee.name;
        this.address = new Address(employee.getAddress());
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "address=" + address +
                ", name='" + name + '\'' +
                '}';
    }
}
