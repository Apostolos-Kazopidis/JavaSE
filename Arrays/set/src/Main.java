import java.util.Arrays;
import java.util.Random;

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
        final int SIZE = 10;
        int[] intAr = new int[SIZE];
        Random r = new Random();

        Arrays.setAll(intAr,n->r.nextInt(1000));

        printArray(intAr);

        Arrays.setAll(intAr,n->n*n);

        printArray(intAr);

        Person[] persons = new Person[10];
        Arrays.setAll(persons,n->new Person("",",","",n));
        printArray(persons);




    }
}