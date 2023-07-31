import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers,3,5,2,1,5,6,2,1,4,5,6,7);

        System.out.println("min: " + numbers.stream().min(Integer::compareTo));
        System.out.println("max: " + numbers.stream().max(Integer::compareTo));
        System.out.println("anyMatch>10: " + numbers.stream().anyMatch(n->n>10));

        String result =
                numbers.stream()
                        .map(x->x*x)
                        .filter(x->x>10)
                        .sorted()
                        .map(Object::toString)
                        .collect(
                                ArrayList<String>::new,
                                ArrayList<String>::add,
                                ArrayList<String>::addAll
                        )
                        .toString();
        System.out.println(result);
    }
}