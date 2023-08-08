import java.io.IOException;
import java.net.*;

public class Main {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.psounis.gr/plh20.html");
            System.out.println(url.getContent().getClass());

            url = new URL("http://www.psounis.gr/youtube20.png");
            System.out.println(url.getContent().getClass());


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
