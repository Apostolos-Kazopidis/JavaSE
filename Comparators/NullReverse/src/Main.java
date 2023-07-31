import java.util.Comparator;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<Person, Integer> grades = new TreeMap<>(
                Comparator.nullsLast(Comparator.comparing(Person::getLastName)
                          .thenComparing(Person::getFirstName)
                          .thenComparingInt(Person::getAge)
                .reversed())
        );
        grades.put(new Person("William", "Kunstler", "Trafalgar sq", 17), 9);
        grades.put(new Person("Bob", "Kunstler", "11th str", 18), 4);
        grades.put(new Person("Bob", "Kunstler", "42nd road", 19), 8);
        grades.put(new Person("Jerry", "Rubin", "1st ave", 17), 7);
        grades.put(null, 0);

        System.out.println(grades);
    }
}

