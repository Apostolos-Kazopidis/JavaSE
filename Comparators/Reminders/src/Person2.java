public class Person2 {
    private String firstName;
    private String lastName;
    private String address;

    public Person2(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    @Override
    public String toString() {
        return firstName + ' ' + lastName +
                '(' + address + ')';
    }

    public String getLastName() {
        return lastName;
    }
}
