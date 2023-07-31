import java.math.BigDecimal;
import java.math.MathContext;

public class Main {
    public static void main(String[] args) {
        BigDecimal b = new BigDecimal("1.111");
        BigDecimal b2 = new BigDecimal("111");

        for (int i=1; i<5; i++)
            System.out.println(b.multiply(b2,new MathContext(i)));




    }
}


