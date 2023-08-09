import java.io.IOException;
import java.net.*;
import java.time.Instant;
import java.time.ZoneId;

public class Main {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.psounis.gr/plh20.html");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            System.out.println("content-encoding: " + connection.getContentEncoding());
            System.out.println("content-length: " + connection.getContentLength());
            System.out.println("content-type: " + connection.getContentType());
            System.out.println("date: " + connection.getDate());
            System.out.println("expires: " + connection.getExpiration());
            System.out.println("last-modified: " + connection.getLastModified());

            System.out.println("last-modified as datetime: " +
                    Instant.ofEpochMilli(connection.getLastModified())
                            .atZone(ZoneId.systemDefault())
                            .toLocalDateTime());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
