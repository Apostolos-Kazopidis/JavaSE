import javax.net.ssl.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        SSLSocketFactory factory = (SSLSocketFactory)
                SSLSocketFactory.getDefault();
        try {
            SSLSocket socket = (SSLSocket)
                    factory.createSocket("www.google.com", 443);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
