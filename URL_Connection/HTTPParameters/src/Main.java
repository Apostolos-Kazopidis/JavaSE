import java.io.IOException;
import java.net.*;

public class Main {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.psounis.gr/plh20.html");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            System.out.println("URL: " + connection.getURL());
            System.out.println("Do Input: " + connection.getDoInput());
            System.out.println("Do Output: " + connection.getDoOutput());
            System.out.println("Allow User Interaction: " + connection.getAllowUserInteraction());
            System.out.println("Use Caches: " + connection.getUseCaches());
            System.out.println("If Modified Since: " + connection.getIfModifiedSince());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

