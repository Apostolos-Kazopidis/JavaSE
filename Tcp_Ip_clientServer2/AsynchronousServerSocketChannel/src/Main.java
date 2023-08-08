import java.io.*;
import java.net.*;
import java.nio.channels.*;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        // make the server
        try (AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open()) {
            server.bind(new InetSocketAddress(1234));
            System.out.println("Server ready!");

            Future<AsynchronousSocketChannel> futureClient = server.accept();
            for (int i = 0; i < 5; i++) {
                if (!futureClient.isDone()) {
                    System.out.println("no incoming connections");
                    Thread.sleep(500);
                } else {
                    AsynchronousSocketChannel sockClient = futureClient.get();
                }

            }
        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}