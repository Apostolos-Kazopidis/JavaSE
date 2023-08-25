import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.wired.com");
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1) Firefox/47.0");
            connection.setRequestProperty("Accept", "text/html");
            connection.addRequestProperty("Accept", "image/gif");

            Map<String, List<String>> headers = connection.getRequestProperties();

            System.out.println(headers.size());
            for (var header: headers.keySet()) {
                System.out.print("\n" + header + ": ");
                for (var value: headers.get(header))
                    System.out.print(value + " ");
            }

            // response headers
            System.out.println("=".repeat(30));
            System.out.println("code: " + connection.getResponseCode());
            System.out.println("message: " + connection.getResponseMessage());

            int i=1;
            while (connection.getHeaderFieldKey(i)!=null) {
                System.out.print(connection.getHeaderFieldKey(i));
                System.out.println(": " + connection.getHeaderField(i));
                i++;
            }

            // response
            System.out.println("=".repeat(30));
            try (Scanner sc = new Scanner(connection.getInputStream())) {
                while (sc.hasNext()) {
                    System.out.println(sc.nextLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

