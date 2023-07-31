import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(List.of(1,2,3,4,5));
        ArrayList<Integer> array2 = new ArrayList<>(List.of(6,7,8,9,10));
        Collections.copy(array, array2);
        System.out.println(array);
        System.out.println(Collections.indexOfSubList(
                array,
                List.of(7,8)
        ));
        System.out.println(Collections.lastIndexOfSubList(
                List.of(1,2,1,2,1,2,1,2),
                List.of(2,1,2)
        ));
    }
}

