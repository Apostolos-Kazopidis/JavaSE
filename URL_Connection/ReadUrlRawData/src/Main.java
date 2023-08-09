import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.psounis.gr/plh20.html");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            try (Scanner sc = new Scanner(connection.getInputStream())) {
                while (sc.hasNext()) {
                    System.out.println(sc.nextLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
