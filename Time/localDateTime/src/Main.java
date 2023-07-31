import java.time.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now().withNano(0);
        System.out.println(now);

        Random r = new Random();

        ArrayList<LocalDateTime> al = new ArrayList<>();
        for (int i=0; i<10; i++)
            al.add(LocalDateTime.of(2021, 12, 1+r.nextInt(3), r.nextInt(24), r.nextInt(60)));

        Collections.sort(al);
        System.out.println(al);
    }
}

