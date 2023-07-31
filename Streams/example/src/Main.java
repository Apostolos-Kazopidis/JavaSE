import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Random r = new Random();
        var stats = Stream.generate(()->r.nextInt(20))
                .limit(10)
                .peek(x-> System.out.print(x + " "))
                .map(x->x*x)
                .filter(x->x<10)
                .collect(Collectors.summarizingInt(x->x));
        System.out.println("\n" + stats.getSum());
    }
}


