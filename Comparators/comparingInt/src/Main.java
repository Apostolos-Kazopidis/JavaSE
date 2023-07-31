import com.sun.source.tree.Tree;

import java.util.Comparator;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<Person, Integer> grades = new TreeMap<>(Comparator.comparingInt(Person::getAge));

        grades.put(new Person("William", "Kunstler", "Trafalgar sq", 17), 9);
        grades.put(new Person("Abbie", "Hoffman", "11th str", 18), 4);
        grades.put(new Person("Tom", "Hayden", "42nd road", 19), 8);
        grades.put(new Person("Jerry", "Rubin", "1st ave", 17), 7);

        System.out.println(grades);
    }
}

