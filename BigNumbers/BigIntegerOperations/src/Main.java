import java.math.BigInteger;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BigInteger b = new BigInteger("123456789012345678901234567890");
        System.out.println(b.add(new BigInteger("9876543210")).divide(new BigInteger("3")).negate());
        System.out.println(Arrays.toString(b.divideAndRemainder(new BigInteger("123456"))));
    }
}

