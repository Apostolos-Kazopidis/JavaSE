public class Main {
    public static void main(String[] args) {
        for (int i=0; i<4; i++) {
            System.out.println("sin(" + i + "*PI/2) = " +
                    Math.sin(i*Math.PI/2));
            System.out.println("cos(" + i + "*PI/2) = " +
                    Math.cos(i*Math.PI/2));
            System.out.println("tan(" + i + "*PI/2) = " +
                    Math.tan(i*Math.PI/2));
            System.out.println("=".repeat(20));
        }
    }
}

