import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] array = {
            {1,2,3,4,5}, // row 0
            {1,2,6,7,9,11}, //row 1
            {1,2,3,4,5,6}, // row 2
            {1,2,3,7,1,1} // row 3
        };

        System.out.println(Arrays.compare(array[0], array[2]));
        System.out.println(Arrays.compare(array[2], array[3])); 
        System.out.println(Arrays.compare(array[3], array[2]));

        Arrays.sort(array, Arrays::compare);
        System.out.println(Arrays.deepToString(array));
    }
}

