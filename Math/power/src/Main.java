public class Main {
    public static void main(String[] args) {
        System.out.println(Math.E==Math.exp(1));
        System.out.println(Math.exp(1)-1==Math.expm1(1));
        System.out.println(Math.sqrt(9)==3);
        System.out.println(Math.sqrt(-1));
        System.out.println(Double.isNaN(Math.sqrt(-1)));

    }
}

