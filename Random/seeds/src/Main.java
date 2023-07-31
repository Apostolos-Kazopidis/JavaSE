import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // same seeds => same numbers
        Random r1 = new Random(0);
        for (int i=0; i<5; i++)
            System.out.println(r1.nextInt());
        System.out.println("=".repeat(10));
        Random r2 = new Random(0);
        for (int i=0; i<5; i++)
            System.out.println(r2.nextInt());

    }
}

