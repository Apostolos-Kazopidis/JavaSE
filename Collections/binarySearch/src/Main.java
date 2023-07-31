import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> array = new ArrayList<>();
        array.add(new Person("William", "Kunstler", "Trafalgar sq", 17));
        array.add(new Person("Bob", "Kunstler", "11th str", 18));
        array.add(new Person("Bob", "Kunstler", "42nd road", 19));
        array.add(new Person("Jerry", "Rubin", "1st ave", 17));

        var comparator = Comparator.comparing(Person::getLastName)
                .thenComparing(Person::getFirstName);
        array.sort(comparator);
        System.out.println(array);
        int pos = Collections.binarySearch(
                array,
                new Person("Jerry", "Rubin", "1st ave", 17),
                comparator);
        System.out.println("Position: " + pos);

        ArrayList<Integer> al = new ArrayList<>(List.of(7,4,2));
        Collections.sort(al);
        System.out.println(al);
        System.out.println("Position: " +
                Collections.binarySearch(al, 6));
    }
}

