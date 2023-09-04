import java.io.IOException;
import java.util.logging.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Logger loggerA = Logger.getLogger("A");
        Logger loggerB = Logger.getLogger("A.B");
        Logger loggerC = Logger.getLogger("A.B.C");

        loggerA.setLevel(Level.CONFIG);
        loggerB.setLevel(Level.FINE);
        loggerC.setLevel(Level.FINER);

        Handler handlerA = new FileHandler("A.log");
        Handler handlerB = new FileHandler("B.log");
        Handler handlerC = new FileHandler("C.log");

        loggerA.addHandler(handlerA);
        loggerB.addHandler(handlerB);
        loggerC.addHandler(handlerC);

        loggerC.log(Level.FINE, "A fine message on C");
        loggerC.log(Level.FINEST, "A finest message on C");
    }
}
