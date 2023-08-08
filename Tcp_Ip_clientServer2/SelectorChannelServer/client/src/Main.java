import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        // make the client
        try (AsynchronousSocketChannel client =
                     AsynchronousSocketChannel.open()) {
            Thread.sleep(1000);
            Future<Void> checkConn = client.connect(new InetSocketAddress("127.0.0.1", 1234));
            checkConn.get();


        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}