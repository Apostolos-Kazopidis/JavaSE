import java.time.*;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now().withNano(0);
        System.out.println(now);

        LocalTime later = now.plus(1, ChronoUnit.HOURS)
                .plus(30, ChronoUnit.MINUTES);
        System.out.println(later);
        System.out.println(later.isBefore(now));
    }
}

