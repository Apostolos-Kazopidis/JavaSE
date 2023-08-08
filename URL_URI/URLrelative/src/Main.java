import java.net.*;

public class Main {

    public static void main(String[] args) {
        try {
            URL baseUrl = new URL("http://www.psounis.com/users/file.html");
            System.out.println("base URL: " + baseUrl);
            URL sameDirUrl = new URL(baseUrl, "doc.html");
            System.out.println("relative URL: " + sameDirUrl);
            URL domainRelUrl = new URL(baseUrl, "/pages/doc.html");
            System.out.println("domain relative URL: " + domainRelUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
