import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        final int SIZE = 10;
        int[] array = new int[SIZE];

        Arrays.setAll(array, n->r.nextInt(10));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        Arrays.parallelPrefix(array, (x,y)->x+y);
        System.out.println(Arrays.toString(array));

        Arrays.setAll(array, n->n+1);
        System.out.println(Arrays.toString(array));
        Arrays.parallelPrefix(array, (x,y)->x*y);
        System.out.println(Arrays.toString(array));
    }
}

