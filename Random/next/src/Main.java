import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();

        for (int i=0; i<2; i++) {
            r.setSeed(1);
            byte[] array = new byte[10];
            r.nextBytes(array);
            System.out.println(Arrays.toString(array));
        }


    }
}

