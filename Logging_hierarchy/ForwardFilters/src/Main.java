import java.io.IOException;
import java.util.logging.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Logger loggerA = Logger.getLogger("A");
        Logger loggerB = Logger.getLogger("A.B");
        Logger loggerC = Logger.getLogger("A.B.C");

        Handler handlerA = new FileHandler("A.log");
        Handler handlerB = new FileHandler("B.log");
        Handler handlerC = new FileHandler("C.log");

        loggerA.addHandler(handlerA);
        loggerB.addHandler(handlerB);
        loggerC.addHandler(handlerC);

        loggerC.setFilter(message->
                message.getMessage().contains("C")
        );
        loggerB.setFilter(message->
                message.getMessage().contains("B")
        );
        loggerA.setFilter(message->
                message.getMessage().contains("A")
        );

        loggerC.log(Level.SEVERE, "C");
    }
}
