import java.util.*;

public class Main {
    public static void printArray(int[] array) {
        System.out.print("[");
        for (var item: array)
            System.out.print(item + " ");
        System.out.println("]");
    }

    public static void printArray(Object[] array) {
        System.out.print("[");
        for (var item: array)
            System.out.print(item + " ");
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] intAr = new int[10];
        Random r = new Random();
        for (int i=0; i<10; i++)
            intAr[i] = r.nextInt(10);
        printArray(intAr);
        Arrays.sort(intAr);
        printArray(intAr);

        Person[] array = {
            new Person("William", "Kunstler", "Trafalgar sq", 17),
            new Person("Bob", "Kunstler", "11th str", 18),
            new Person("Bob", "Kunstler", "42nd road", 19),
            new Person("Jerry", "Rubin", "1st ave", 17)
        };
        Arrays.sort(array);
        printArray(array);

        Integer[] integerAr = new Integer[10];
        for (int i=0; i<10; i++)
            integerAr[i] = r.nextInt(10);
        printArray(integerAr);
        Arrays.sort(integerAr, 1, 9, Integer::compareTo);
        printArray(integerAr);

        Arrays.sort(array, Comparator.comparing(Person::getAge).
                thenComparing(Person::getFirstName).reversed());
        printArray(array);

    }
}

