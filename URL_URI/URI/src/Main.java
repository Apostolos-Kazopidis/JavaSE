import java.net.*;

public class Main {

    public static void main(String[] args) {
        try {
            URI wrongURI = new URI("htτp://www.psounis.com");
        } catch (URISyntaxException e) {
            System.out.println("Syntax Error");
        }

        try {
            URI uri = new URI("http://jim:1234@www.psounis.com:80/java16.html?id=1#footer");
            System.out.println("scheme: " + uri.getScheme());
            System.out.println("authority: " + uri.getAuthority());
            System.out.println("host: " + uri.getHost());
            System.out.println("user info: " + uri.getUserInfo());
            System.out.println("path: " + uri.getPath());
            System.out.println("query: " + uri.getQuery());
            System.out.println("fragment: " + uri.getFragment());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
