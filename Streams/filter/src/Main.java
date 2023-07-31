import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> al = new ArrayList<>();
        Collections.addAll(al, 1,2,3,4,5);

        List<Integer> array = al.stream()
                .filter(x->x%2==0)
                .collect(Collectors.toList());
        System.out.println(array);

        List<Integer> array2 = al.stream()
                .map(x->x*x)
                .filter(x->x%2==0)
                .map(x->x/2)
                .collect(Collectors.toList());
        System.out.println(array2);
    }
}


