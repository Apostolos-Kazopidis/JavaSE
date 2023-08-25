import java.io.*;
import java.net.*;
import javax.net.ssl.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        SSLSocketFactory factory = (SSLSocketFactory)
                SSLSocketFactory.getDefault();

        try (SSLSocket socket = (SSLSocket)
                factory.createSocket("www.google.com", 443);
             Scanner in = new Scanner(socket.getInputStream()) ;
             OutputStream out = socket.getOutputStream()) {

            socket.setEnabledCipherSuites(socket.getSupportedCipherSuites());
            out.write("GET / HTTP/1.0\r\n\r\n".getBytes(StandardCharsets.UTF_8));
            out.flush();
            while (in.hasNext())
                System.out.println(in.nextLine());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}