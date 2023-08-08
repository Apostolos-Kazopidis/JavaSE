import java.io.*;
import java.net.*;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {


        // make the selector and the server
        try (Selector selector = Selector.open();
             ServerSocketChannel server = ServerSocketChannel.open()) {

            server.configureBlocking(false); // important! Selectors only use non-blocking channels
            server.bind(new InetSocketAddress(1234));
            server.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                Thread.sleep(1000);
                selector.selectNow();
                Set<SelectionKey> keyEvents = selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = keyEvents.iterator();
                System.out.print("\nEvents: ");
                while (keyIterator.hasNext()) {
                    SelectionKey keyEvent = keyIterator.next();
                    server.accept();
                    System.out.print(keyEvent + " ");
                    keyIterator.remove();
                }
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}