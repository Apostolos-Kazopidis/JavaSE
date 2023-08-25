import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import java.io.IOException;
import java.net.*;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.time.Instant;
import java.time.ZoneId;
import java.util.*;

public class Main {
    public static void printSessionInfo(SSLSession session) {
        System.out.println("Cipher Suite: " + session.getCipherSuite());
        System.out.println("Creation Time: " +
                Instant.ofEpochMilli(session.getCreationTime()).
                        atZone(ZoneId.systemDefault()).toLocalDateTime());
        System.out.println("Last Accessed Time: " +
                Instant.ofEpochMilli(session.getLastAccessedTime()).
                        atZone(ZoneId.systemDefault()).toLocalDateTime());
        System.out.println("Is valid: " + session.isValid());
    }

    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.wired.com");
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1) Firefox/47.0");
            connection.setRequestProperty("Accept", "text/html");

            connection.connect();

            // session
            Optional<SSLSession> optionalSSLSession = connection.getSSLSession();
            if (optionalSSLSession.isPresent()) {
                SSLSession session = optionalSSLSession.get();
                printSessionInfo(session);
            }
            else
                System.out.println("no session");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


