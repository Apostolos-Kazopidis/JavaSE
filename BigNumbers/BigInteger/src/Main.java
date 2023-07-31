import java.math.BigInteger;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        BigInteger b = new BigInteger("111", 16);
        System.out.println(b);
        BigInteger b2 = new BigInteger("123456789012345678901234567890");
        System.out.println(b2);
        Random r = new Random();
        byte[] array = new byte[1000];
        for (int i=0; i<1000; i++)
            array[i] = (byte) r.nextInt(255);
        BigInteger b3 = new BigInteger(-1, array);
        System.out.println(b3);
    }
}

