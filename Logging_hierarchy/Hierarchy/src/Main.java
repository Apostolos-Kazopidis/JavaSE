import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger loggerA = Logger.getLogger("A");
        Logger loggerB = Logger.getLogger("A.B");
        Logger loggerC = Logger.getLogger("A.B.C");

        System.out.println("Parent of C: " + loggerC.getParent().getName());
        System.out.println("Parent of B: " + loggerB.getParent().getName());
        System.out.println("Parent of A: " + loggerA.getParent().getName());
        System.out.println("Object: " + loggerA.getParent());
        System.out.println();


        Logger loggerE = Logger.getLogger("D.E");
        System.out.println("Parent of E: " +  loggerE.getParent().getName());
        System.out.println("Object: " + loggerE.getParent());
    }
}
