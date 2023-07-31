import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();

        var stream = r.ints(100, 0, 10);
        stream.forEach(n-> System.out.println(n));

        stream = r.ints(100, 0, 10);
        System.out.println(stream.reduce(0, (a,b)->a+b));
    }
}

