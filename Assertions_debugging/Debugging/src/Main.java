import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void selectionSort(int[] array) {
        for (int i=0; i<array.length-1; i++) {
            int min = Integer.MAX_VALUE;
            int pos = i;
            for (int j=i; j<array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    pos = j;
                }
            }
            swap(array, i, pos);
        }
    }

    public static boolean checkSorted(int[] array) {
        for (int i=0; i<array.length-2; i++)
            if (array[i] > array[i+1])
                return false;
            return true;
    }

    public static void main(String[] args) {
        int[] array = new int[10];
        Random r = new Random();
        Arrays.setAll(array, n->r.nextInt(100));
        System.out.println("Initial: " + Arrays.toString(array));
        selectionSort(array);
        assert checkSorted(array): "not sorted!";
        System.out.println("Final: " + Arrays.toString(array));
    }
}

