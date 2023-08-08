import java.io.*;
import java.net.*;
import java.nio.channels.*;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        // make the client
        try (AsynchronousSocketChannel client = AsynchronousSocketChannel.open()) {
            Thread.sleep(1000);
            Future<Void> checkConn = client.connect(
                    new InetSocketAddress("127.0.0.1", 1234));
            Thread.sleep(100);
            if (checkConn.isDone())
                System.out.println("Client ready!");
            else
                System.out.println("Not Connected");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}