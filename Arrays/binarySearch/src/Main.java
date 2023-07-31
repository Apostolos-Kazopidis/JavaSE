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
        System.out.println("binarySearch(4): " +
                Arrays.binarySearch(intAr, 4));
        System.out.println("=".repeat(20));


        Person[] array = {
            new Person("William", "Kunstler", "Trafalgar sq", 17),
            new Person("Bob", "Kunstler", "11th str", 18),
            new Person("Bob", "Kunstler", "42nd road", 19),
            new Person("Jerry", "Rubin", "1st ave", 17)
        };
        Arrays.sort(array);
        printArray(array);
        System.out.println("binarySearch(Kunstler19): " +
                Arrays.binarySearch(array,
                        new Person("Bob", "Kunstler", "42nd road", 19)));
        System.out.println("=".repeat(20));


        Integer[] integerAr = new Integer[10];
        for (int i=0; i<10; i++)
            integerAr[i] = r.nextInt(10);
        printArray(integerAr);
        Arrays.sort(integerAr, 1, 9,
                Integer::compareTo);
        printArray(integerAr);
        System.out.println("binarySearch(4): " +
                Arrays.binarySearch(integerAr, 1, 9, 4,
                        Integer::compareTo));
        System.out.println("=".repeat(20));

        Comparator<Person> compPerson = Comparator.comparing(Person::getAge).
                thenComparing(Person::getFirstName).reversed();
        Arrays.sort(array, compPerson);
        printArray(array);
        System.out.println("binarySearch(Kunstler19): " +
                Arrays.binarySearch(array,
                        new Person("Bob", "Kunstler", "42nd road", 19),
                        compPerson));

    }
}

