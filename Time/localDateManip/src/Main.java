import java.time.*;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        System.out.println(today.isBefore(tomorrow));

        LocalDate almostAYearAgo = today.withYear(2020).withMonth(today.getMonthValue()-1);
        System.out.println(almostAYearAgo);

        System.out.println(LocalDate.MIN);
        System.out.println(LocalDate.MAX);
        System.out.println(LocalDate.EPOCH);
    }
}

