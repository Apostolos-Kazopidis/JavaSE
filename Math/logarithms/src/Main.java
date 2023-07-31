public class Main {
    public static double logab(double number, double base) {
        return Math.log(number)/Math.log(base);
    }

    public static void main(String[] args) {
        int number = 10;

        while (number<=10000) {
            number*=10;
            System.out.println("log(base=10)" + number + "=" +
                    Math.log10(number));
        }

        System.out.println(logab(3, 2));
    }
}

