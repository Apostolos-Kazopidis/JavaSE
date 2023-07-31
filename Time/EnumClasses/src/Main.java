import java.time.*;

public class Main {
    public static void main(String[] args) {
        LocalDate now = LocalDate.of(1988, Month.APRIL, 13);
        System.out.println(now);

        MonthDay md = MonthDay.of(Month.APRIL, 10);
        LocalDate d = md.atYear(1990);
        System.out.println(d);
        System.out.println(d.getDayOfWeek().equals(DayOfWeek.SUNDAY)? "Holiday": "Working Day");
    }
}

