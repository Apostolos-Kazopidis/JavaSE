import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(List.of(1,2,3,4,5));
        System.out.println(array);
        Collections.shuffle(array);
        System.out.println(array);
        Collections.replaceAll(array, 1, 3);
        Collections.reverse(array);
        System.out.println(array);
        Collections.rotate(array, 2);
        System.out.println(array);
    }
}

