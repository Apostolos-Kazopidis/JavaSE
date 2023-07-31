import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        BigInteger b = new BigInteger("1"); //001
        BigInteger b2 = b.setBit(1).setBit(2); //111
        System.out.println(b2); // 7
        System.out.println(b.xor(b2)); // 001 XOR 111 == 110 (6)
        System.out.println(b2.shiftRight(1)); // 111 -> 011 (3)
        int x = new BigInteger("1234567890123").intValueExact();
    }
}
