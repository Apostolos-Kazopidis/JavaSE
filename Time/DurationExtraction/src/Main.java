import java.time.*;

public class Main {
    public static void main(String[] args) {
        // years old
        LocalDateTime birthday = LocalDateTime.of(1980, 4, 25,0,0);
        LocalDateTime now = LocalDateTime.now();

        Duration d2 = Duration.between(birthday, now);
        System.out.println(d2);
        System.out.println("Years: " + d2.toDays()/365);
        System.out.println("Months: " + d2.toDays()/30);
        System.out.println("Days: " + d2.toDays());
        System.out.println("Hours: " + d2.toHours());
        System.out.println("Minutes: " + d2.toMinutes());
        System.out.println("Seconds: " + d2.toSeconds());
    }
}

