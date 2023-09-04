import java.io.IOException;
import java.util.logging.*;

public class Main {
    public static Logger logger;
    static {
        try {
            logger = Logger.getLogger(Main.class.getName());
            // save them to a file
            FileHandler handler = new FileHandler("logs.log");
            handler.setFormatter(new SimpleFormatter());
            logger.addHandler(handler);
            // also, print them to the console
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.FINEST);
            logger.addHandler(consoleHandler);
            // and to the logserver
            SocketHandler socketHandler = new SocketHandler("127.0.0.1", 1234);
            logger.addHandler(socketHandler);
            socketHandler.setLevel(Level.FINEST);

            logger.setLevel(Level.FINEST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static long fib(int n) {
        logger.entering("Main", "fib", n);
        if (n==0 || n==1) {
            logger.exiting("Main", "fib", 1);
            return 1;
        }
        else {
            long prev = fib(n-1);
            long prev2 = fib(n-2);

            logger.exiting("Main", "fib", prev+prev2);
            return prev+prev2;
        }
    }

    public static void main(String[] args) {
        long res = fib(10);
        System.out.println("result: " + res);
    }
}