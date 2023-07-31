public class Person {
    private String firstName;
    private String lastName;
    private String address;
    private double salary;

    public Person(String firstName, String lastName, String address, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return firstName + ' ' + lastName +
                '(' + address + ')';
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public String getFirstName() {
        return firstName;
    }
}
