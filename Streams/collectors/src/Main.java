import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        HashSet<Integer> hs = Stream.iterate(10, n->n+2)
                .limit(10)
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println(hs);

        System.out.println("\n" + "=".repeat(20));
        Random r = new Random();
        String rand = Stream.generate(()->r.nextInt(20))
                .limit(10)
                .peek(x-> System.out.println(x))
                .map(x->String.valueOf(x))
                .collect(Collectors.joining(" "));
        System.out.println(rand);

        System.out.println("\n" + "=".repeat(20));
        var result =Stream.generate(()->r.nextInt(20))
                .limit(10)
                .peek(x-> System.out.print(x + " "))
                .collect(Collectors.summarizingInt(x->x));
        System.out.println("max: " + result.getMax());
        System.out.println("min: " + result.getMin());
        System.out.println("cnt: " + result.getCount());
        System.out.println("sum: " + result.getSum());
        System.out.println("avg: " + result.getAverage());

    }
}


