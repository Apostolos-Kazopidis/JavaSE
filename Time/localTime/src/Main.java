import java.time.*;

public class Main {
    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        System.out.println(time);

        LocalTime atime = LocalTime.of(22, 1, 11);
        System.out.println(atime);
        System.out.println(atime.getHour()+":"+atime.getMinute()+":"+atime.getSecond());
    }
}

