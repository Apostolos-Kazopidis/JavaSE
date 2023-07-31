public class Person {
    private String firstName;
    private String lastName;
    private String address;
    private double salary;
    public int x = 1;

    public static int objCount = 0;

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

    private void printSalary() {
        System.out.println(salary);
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

    public static void incObjCount() { objCount++; }
    public static void incDecCount() { objCount--; }
}
