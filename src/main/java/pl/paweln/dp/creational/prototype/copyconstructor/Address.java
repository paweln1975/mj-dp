package pl.paweln.dp.creational.prototype.copyconstructor;

public class Address {
    private String streetName;
    private String postalCode;
    private String city;

    public Address(String streetName, String postalCode, String city) {
        this.streetName = streetName;
        this.postalCode = postalCode;
        this.city = city;
    }

    public Address (Address address) {
        this(address.streetName, address.postalCode, address.city);
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
