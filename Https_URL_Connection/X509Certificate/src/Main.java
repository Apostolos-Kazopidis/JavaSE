import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.*;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.*;

public class Main {

    public static void printCertificateInfo(X509Certificate certificate) {
        System.out.println("=".repeat(30));
        System.out.println("not valid before: " + certificate.getNotBefore());
        System.out.println("not valid after: " + certificate.getNotAfter());
        System.out.println("version: " + certificate.getVersion());
        System.out.println("Serial Number: " + certificate.getSerialNumber());
        System.out.println("DN: " + certificate.getIssuerX500Principal().getName());
    }

    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.wired.com");
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1) Firefox/47.0");
            connection.setRequestProperty("Accept", "text/html");

            connection.connect();

            // server certificates
            Certificate[] certificates = connection.getServerCertificates();
            for (var cert: certificates) {
                System.out.println("\n\nServer Certificate");
                printCertificateInfo((X509Certificate) cert);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


