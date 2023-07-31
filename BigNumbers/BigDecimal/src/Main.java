import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BigDecimal b = new BigDecimal("123456789012345678901234567890.12345678901234567890");
        BigDecimal b2 = new BigDecimal(1/3);
        BigDecimal b3 = new BigDecimal(1.0/3.0);
        BigDecimal b4 = new BigDecimal("0.3333333");
        //BigDecimal b5 = new BigDecimal("1/3");
        System.out.println(b + "\n" + b2 + "\n" + b3 + "\n" + b4);
    }
}

