import java.net.*;

public class Main {

    public static void main(String[] args) {
        try {
            URL wrongURI = new URL("htτp://www.psounis.com");
        } catch (MalformedURLException e) {
            System.out.println("Syntax Error");
        }

        try {
            URL url = new URL("http://jim:1234@www.psounis.com:80/java16.html?id=1#footer");
            System.out.println("protocol: " + url.getProtocol());
            System.out.println("authority: " + url.getAuthority());
            System.out.println("user info: " + url.getUserInfo());
            System.out.println("host: " + url.getHost());
            System.out.println("port: " + url.getPort());
            System.out.println("path: " + url.getPath());
            System.out.println("query: " + url.getQuery());
            System.out.println("ref: " + url.getRef());
            System.out.println("file: " + url.getFile());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
