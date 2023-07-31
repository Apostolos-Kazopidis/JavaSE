import java.util.*;

public class Main {
    public static void main(String[] args) {
        final int SIZE = 100000000;
        int[] intAr1 = new int[SIZE];
        int[] intAr2 = new int[SIZE];
        Random r = new Random();
        for (int i=0; i<SIZE; i++) {
            int val = r.nextInt(100000);
            intAr1[i] = val;
            intAr2[i] = val;
        }

        long startTime = System.currentTimeMillis();
        Arrays.sort(intAr1);
        long endTime = System.currentTimeMillis();
        System.out.println("Casual Sort: " +(endTime - startTime)/1000.0);

        startTime = System.currentTimeMillis();
        Arrays.parallelSort(intAr2);
        endTime = System.currentTimeMillis();
        System.out.println("Parallel Sort: " +(endTime - startTime)/1000.0);

    }
}

