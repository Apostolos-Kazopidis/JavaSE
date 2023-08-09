import java.io.IOException;
import java.net.*;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.psounis.gr/plh20.html");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

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

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
