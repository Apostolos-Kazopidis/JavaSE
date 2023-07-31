public class Main {
    public static void main(String[] args) {
        int sum = Integer.MAX_VALUE+1;

        System.out.println(sum);
        try {
            sum = Math.addExact(Integer.MAX_VALUE, 1);
        } catch (ArithmeticException e) {
            System.err.println("Overflow");
        }
    }
}

