import java.net.*;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://jim:1234@www.psounis.com:80/java16.html?id=1#footer");
            System.out.println("URL: " + url);
            URI uri = url.toURI();
            System.out.println("URI: " + uri);

            Path path = Path.of("D:\\JAVA-Psounis\\JAVA-SE");
            System.out.println(path.toUri() + " " + path.toUri().toURL());
        } catch (MalformedURLException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
