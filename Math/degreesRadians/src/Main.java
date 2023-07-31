public class Main {
    public static void main(String[] args) {

        for (int deg=0; deg<360; deg+=90) {
            System.out.println("sin(" + deg + "deg) = " +
                    Math.sin(Math.toRadians(deg)));
            System.out.println("cos(" + deg + "deg) = " +
                    Math.cos(Math.toRadians(deg)));
            System.out.println("tan(" + deg + "deg) = " +
                    Math.tan(Math.toRadians(deg)));
            System.out.println("=".repeat(20));
        }

        System.out.println("My Solution");
        System.out.println("-".repeat(20));

        for(int deg=0; deg<=360; deg+=90) {
            System.out.println("sin("+deg+") ="+Math.sin(Math.toRadians(deg)));
            System.out.println("cos("+deg+") ="+Math.cos(Math.toRadians(deg)));
            System.out.println("tan("+deg+") ="+Math.tan(Math.toRadians(deg)));
            System.out.println("=".repeat(20));
        }



    }
}

