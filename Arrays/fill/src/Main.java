import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] ar1 = new int[5];

        Arrays.fill(ar1, 5);
        int[] ar2 = Arrays.copyOf(ar1, ar1.length+2);
        System.out.println(Arrays.toString(ar2));

        int[] ar3 = Arrays.copyOfRange(ar2, 4, 7);
        System.out.println(Arrays.toString(ar3));
    }
}

