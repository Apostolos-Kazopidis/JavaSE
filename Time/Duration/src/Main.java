import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class Main {
    public static void main(String[] args) {
        // 50 days later
        LocalDateTime today = LocalDateTime.now();
        System.out.println(today);

        Duration d = Duration.of(50, ChronoUnit.DAYS);
        LocalDateTime next = (LocalDateTime) d.addTo(today);
        System.out.println(next);

        // years old
        LocalDateTime birthday = LocalDateTime.of(1980, 4, 25,0,0);
        LocalDateTime now = LocalDateTime.now();

        Duration d2 = Duration.between(birthday, now);
        System.out.println(d2);
    }
}

