import java.io.*;
import javax.net.ssl.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        SSLServerSocketFactory factory =
                (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        System.out.println("Supported Cipher Suites: " +
                factory.getSupportedCipherSuites().length);
        for (var cipher: factory.getSupportedCipherSuites())
            System.out.println(cipher);
        System.out.println("\nDefault Cipher Suites: " +
                factory.getDefaultCipherSuites().length);
        for (var cipher: factory.getDefaultCipherSuites())
            System.out.println(cipher);

        try (SSLServerSocket server = (SSLServerSocket)
                factory.createServerSocket(12345)) {

            server.setEnabledCipherSuites(new String[] {
                    "TLS_RSA_WITH_AES_256_GCM_SHA384",
                    "TLS_RSA_WITH_AES_128_GCM_SHA256"
            });
            System.out.println("Server Cipher Suites: " +
                    server.getEnabledCipherSuites().length);

            SSLSocket serverSocket = (SSLSocket) server.accept();

            Scanner in = new Scanner(serverSocket.getInputStream()) ;
            OutputStream out = serverSocket.getOutputStream();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}