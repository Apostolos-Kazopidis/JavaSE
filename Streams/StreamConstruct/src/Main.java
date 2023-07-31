import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        Collections.addAll(al, 1,2,3,4,5);

        Stream<Integer> stream = al.stream();
        System.out.println(stream);

        int[] array = {1,2,3,4,5};
        IntStream intStream = Arrays.stream(array);
        System.out.println(intStream);
    }
}


