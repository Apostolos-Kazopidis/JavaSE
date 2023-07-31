public class Main {
    public static void main(String[] args) {
        double v = 0.0;
        for (int i=0; i<10; i++) {
            v = Math.nextUp(v);
            System.out.println(v);
        }
        System.out.println(Math.ulp(1.0));
        System.out.println(Math.ulp(10.0));
        System.out.println(Math.rint(5.2));
    }
}

