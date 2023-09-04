import java.io.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    public static Logger logger;

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
        try {
            logger = Logger.getLogger(Main.class.getName());
            FileHandler handler = new FileHandler("logs.log");
            handler.setFormatter(new SimpleFormatter());
            logger.addHandler(handler);
            logger.setLevel(Level.FINEST);
        } catch (IOException e) {
            e.printStackTrace();
        }

        long res = fib(10);
        System.out.println("result: " + res);
    }
}
