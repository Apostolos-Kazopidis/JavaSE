import java.time.*;

public class Main {
    public static void main(String[] args) {
        Instant start = Instant.now();

        for (long i=0; i<10000000000L; i++);

        Instant end = Instant.now();

        Duration d = Duration.between(start, end);
        System.out.println(d.toString().substring(2).toLowerCase());

    }
}

