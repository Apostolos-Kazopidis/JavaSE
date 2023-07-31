import java.time.*;

public class Main {
    public static void main(String[] args) {
        ZoneId id = ZoneId.of("UTC+02");
        System.out.println(id);
        System.out.println(ZoneId.getAvailableZoneIds());

        ZonedDateTime time = ZonedDateTime.now();
        System.out.println(time);
        ZonedDateTime time2 = ZonedDateTime.of(
                LocalDateTime.now(), ZoneId.of("Europe/Paris")
        );
        System.out.println(time2);
    }
}

