import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BigDecimal b = new BigDecimal("7");

        BigDecimal b2 = b.scaleByPowerOfTen(20);
        System.out.println(b2);
        System.out.println(b2.toPlainString());

        BigDecimal b3 = b2.add(new BigDecimal("0.000100"));
        System.out.println(b3);
        BigDecimal b4 = b3.stripTrailingZeros();
        System.out.println(b4);

        System.out.println("-".repeat(20));
        System.out.println(b4.precision());
        System.out.println(b4.scale());
        System.out.println(b4.signum());
        System.out.println();

        BigDecimal b5 = b4.round(
                new MathContext(b4.precision()-b4.scale()+2,
                        RoundingMode.HALF_UP)
        );
        System.out.println(b5);

    }
}

