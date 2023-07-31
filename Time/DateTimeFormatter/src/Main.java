import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        System.out.println(
            now.format(DateTimeFormatter.ofPattern("d/M/u '('k:m:s')'"))
        );
        System.out.println(
            now.format(DateTimeFormatter.ofPattern("d/MM/u '('k:m:s')'"))
        );
        System.out.println(
            now.format(DateTimeFormatter.ofPattern("d/MMMM/u '('k:m:s')'"))
        );

        LocalDate prev =
                LocalDate.parse("15.05.18",
                        DateTimeFormatter.ofPattern("dd'.'MM'.'yy"));
        System.out.println(prev);

    }
}

