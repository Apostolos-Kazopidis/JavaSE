import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Stream<Integer> s1 = Stream.<Integer>builder().add(1).add(2).build();
        System.out.println(s1.collect(Collectors.toList()));

        Random r = new Random();
        Stream<Integer> s2 = Stream.generate(()->r.nextInt(10)).limit(10);
        System.out.println(s2.collect(Collectors.toList()));

        Stream<Integer> s3 = Stream.iterate(10, n->n+2).limit(10);
        System.out.println(s3.collect(Collectors.toList()));

        IntStream s4 = IntStream.range(10,20);
        System.out.println(Arrays.toString(s4.toArray()));
    }
}


