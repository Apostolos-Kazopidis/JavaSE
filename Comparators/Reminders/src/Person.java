public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private String address;

    public Person(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    @Override
    public int compareTo(Person o) {
        return lastName.compareTo(o.lastName);
    }

    @Override
    public String toString() {
        return firstName + ' ' + lastName +
                '(' + address + ')';
    }
}
