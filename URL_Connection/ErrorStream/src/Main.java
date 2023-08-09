import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://google.com/1234");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            try (Scanner sc = new Scanner(connection.getInputStream())) {
                while (sc.hasNext())
                    System.out.println(sc.nextLine());
            }
            catch (IOException e) {
                System.out.println("No Input Stream");
            }

            try (Scanner sc = new Scanner(connection.getErrorStream())) {
                while (sc.hasNext())
                    System.out.println(sc.nextLine());
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
