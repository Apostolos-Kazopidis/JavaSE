import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        BigDecimal b = new BigDecimal("1.1");
        BigDecimal b2 = new BigDecimal("2.1");
        BigDecimal badd = b.add(b2);
        System.out.println(badd);
        BigDecimal bsub = b.subtract(b2);
        System.out.println(bsub);
        BigDecimal bmult = b.multiply(b2);
        System.out.println(bmult);

        try {
            System.out.println(new BigDecimal(1).divide(new BigDecimal(7)));
        } catch (ArithmeticException e) {
            System.out.println("Apeira Dekadika");
        }

        //3.1/2=1.55

        BigDecimal n = new BigDecimal("3.1");
        BigDecimal d = new BigDecimal("2");
        System.out.println("=".repeat(15));
        System.out.println(n.divide(d, 1, RoundingMode.HALF_UP));
        System.out.println(n.divide(d, 1, RoundingMode.UP));
        System.out.println(n.divide(d, 1, RoundingMode.DOWN));
        System.out.println(n.divide(d, 1, RoundingMode.CEILING));
        System.out.println(n.divide(d, 1, RoundingMode.FLOOR));

        n = new BigDecimal("-3.1");
        d = new BigDecimal("2");
        System.out.println("=".repeat(15));
        System.out.println(n.divide(d, 1, RoundingMode.HALF_UP));
        System.out.println(n.divide(d, 1, RoundingMode.UP));
        System.out.println(n.divide(d, 1, RoundingMode.DOWN));
        System.out.println(n.divide(d, 1, RoundingMode.CEILING));
        System.out.println(n.divide(d, 1, RoundingMode.FLOOR));

    }
}

