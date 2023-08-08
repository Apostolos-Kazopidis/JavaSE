import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.google.com");

            try (Scanner sc = new Scanner(url.openStream())) {
                while (sc.hasNextLine())
                    System.out.println(sc.nextLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            url = new URL("https://www.psounis.gr/youtube.png");

            try (BufferedInputStream in = new BufferedInputStream(url.openStream())) {
                ;
            } catch (IOException e) {
                System.out.println("https not supported");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
