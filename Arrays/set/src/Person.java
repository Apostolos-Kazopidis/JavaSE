import java.util.Comparator;
import java.util.function.IntFunction;

public class Person implements Comparable<Person>, IntFunction<Person> {
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
    public int compareTo(Person o) {
        if (lastName.equals(o.lastName))
            if (firstName.equals(o.firstName))
                return age - o.age;
            else
                return firstName.compareTo(o.firstName);
        else
            return lastName.compareTo(o.lastName);
    }

    @Override
    public String toString() {
        return firstName + ' ' + lastName +
                '(' + address + ',' + age + ')';
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    @Override
    public Person apply(int value) {
        return new Person("","","", value);
    }
}
