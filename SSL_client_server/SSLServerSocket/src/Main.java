import java.io.*;
import javax.net.ssl.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try (SSLServerSocket server = (SSLServerSocket) factory.createServerSocket(12345)) {

            SSLSocket serverSocket = (SSLSocket) server.accept();

            Scanner in = new Scanner(serverSocket.getInputStream()) ;
            OutputStream out = serverSocket.getOutputStream();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}