import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        BigInteger b = new BigInteger("54");
        BigInteger b2 = new BigInteger("12");
        System.out.println(b.gcd(b2));
        System.out.println(b.min(b2));
        System.out.println(b.max(b2));
        System.out.println(b.pow(10000));
        BigInteger b3 = b.pow(10);
        for (int i=2; i<38; i++)
            System.out.println("base " + i + ": " + b3.toString(i));

    }
}

