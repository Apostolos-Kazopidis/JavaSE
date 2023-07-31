import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        BigDecimal pi = new BigDecimal(Math.PI);
        BigDecimal radius = new BigDecimal("10.5");
        BigDecimal area = pi.multiply(radius.pow(2), new MathContext(4,RoundingMode.HALF_UP));
        System.out.println(area);



    }
}
