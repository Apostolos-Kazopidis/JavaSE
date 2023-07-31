import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<Person, Integer> grades = new TreeMap<>();
        grades.put(new Person("William", "Kunstler", "Trafalgar sq"), 9);
        grades.put(new Person("Abbie", "Hoffman", "11th str"), 4);
        grades.put(new Person("Tom", "Hayden", "42nd road"), 8);
        grades.put(new Person("Jerry", "Rubin", "1st ave"), 7);

        System.out.println(grades);

        TreeMap<Person2, Integer> grades2 = new TreeMap<>(new NameComparator());
        grades2.put(new Person2("William", "Kunstler", "Trafalgar sq"), 9);
        grades2.put(new Person2("Abbie", "Hoffman", "11th str"), 4);
        grades2.put(new Person2("Tom", "Hayden", "42nd road"), 8);
        grades2.put(new Person2("Jerry", "Rubin", "1st ave"), 7);

        System.out.println(grades2);
    }
}

