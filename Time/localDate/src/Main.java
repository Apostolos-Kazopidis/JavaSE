import java.time.*;

public class Main {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalDate ago = LocalDate.of(1929, 1, 15);
        System.out.println(ago.getDayOfMonth() + "/" +
                ago.getMonthValue() + "/" + ago.getYear());
        System.out.println(ago.getDayOfWeek() + ", " + ago.getDayOfMonth() + " " + ago.getMonth() + " " + ago.getYear());
    }
}

