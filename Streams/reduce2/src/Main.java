import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("William", "Kunstler", "Trafalgar sq", 500));
        persons.add(new Person("Abbie", "Hoffman", "11th str", 700));
        persons.add(new Person("Tom", "Hayden", "42nd road", 400));
        persons.add(new Person("Jerry", "Rubin", "1st ave", 800));

        String names = persons.stream()
                .map(Person::getLastName)
                .reduce("",
                        (acc, person)->acc + " " + person);
        System.out.println(names);

        Double totalSalaries = persons.parallelStream()
                .reduce(0.0,
                        (acc,person)-> acc + person.getSalary(),
                        Double::sum);
        System.out.println(totalSalaries);
    }
}