import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> array = new ArrayList<>();
        array.add(new Person("William", "Kunstler", "Trafalgar sq", 17));
        array.add(new Person("Bob", "Kunstler", "11th str", 18));
        array.add(new Person("Bob", "Kunstler", "42nd road", 19));
        array.add(new Person("Jerry", "Rubin", "1st ave", 17));

        //Collections.sort(array,Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName));
        array.sort(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName));
        System.out.println(array);

        array.sort(Comparator.comparingInt(Person::getAge).reversed());
        System.out.println(array);

        ArrayList<Integer> al = new ArrayList<>(List.of(1,2,3));
        Collections.sort(al);
        System.out.println(al);
    }
}

