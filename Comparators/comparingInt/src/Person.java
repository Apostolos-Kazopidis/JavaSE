public class Person {
    private String firstName;
    private String lastName;
    private String address;
    private int age;

    public Person(String firstName, String lastName, String address, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.age = age;
    }

    @Override
    public String toString() {
        return firstName + ' ' + lastName +
                '(' + address + ',' + age + ')';
    }

    public int getAge() {
        return age;
    }
}
