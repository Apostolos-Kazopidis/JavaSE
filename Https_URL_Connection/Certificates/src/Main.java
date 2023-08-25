import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.*;
import java.security.cert.Certificate;
import java.util.*;

public class Main {

    public static void printCertificateInfo(Certificate certificate) {
        System.out.println("=".repeat(30));
        System.out.println(certificate);
        System.out.println("-".repeat(30));
        System.out.println("Type: " + certificate.getType());
        System.out.println("Public Key Algorithm: " + certificate.getPublicKey().getAlgorithm());
        System.out.println("Public Key: " +
                Base64.getEncoder().encodeToString(certificate.getPublicKey().getEncoded()));
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
                printCertificateInfo(cert);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

