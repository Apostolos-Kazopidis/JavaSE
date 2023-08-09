import java.io.IOException;
import java.net.*;

public class Main {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.psounis.gr/plh20.html");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            System.out.println("code: " + connection.getResponseCode());
            System.out.println("message: " + connection.getResponseMessage());

            int i=1;
            while (connection.getHeaderFieldKey(i)!=null) {
                System.out.print(connection.getHeaderFieldKey(i));
                System.out.println(": " + connection.getHeaderField(i));
                i++;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
