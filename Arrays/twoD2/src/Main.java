import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[][] array = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14}
        };

        int[] array2 = {1,2,3,4,5};

        System.out.println(array);
        System.out.println(array.toString());
        System.out.println(array[2]);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array[2]));
        System.out.println(Arrays.deepToString(array));
        System.out.println(array2);
        System.out.println(Arrays.toString(array2));



    }
}