import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> al = new ArrayList<>();
        Collections.addAll(al, 1,2,3,4,5);

        List<Integer> array = al.stream()
                .map(x->x*x)
                .collect(Collectors.toList());
        System.out.println(array);

        List<Integer> array2 = al.stream()
                .map(x->x*x)
                .map(x->x+3)
                .collect(Collectors.toList());
        System.out.println(array2);
    }
}


