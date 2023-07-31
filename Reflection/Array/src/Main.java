import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array1 = new int[10];
        for (int i=0; i< array1.length; i++) array1[i]=i;

        Class<?> arClass = array1.getClass();
        System.out.println(arClass + ": " + Arrays.toString(array1));

        int[] array2 = (int[]) Array.newInstance(int.class, 10);
        for (int i=0; i< array2.length; i++) array2[i]=i;
        Array.set(array2, 4, 10);
        System.out.println(Arrays.toString(array2));

    }
}

