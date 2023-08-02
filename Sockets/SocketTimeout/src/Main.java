import java.io.IOException;
import java.net.*;

public class Main {


    public static void main(String[] args) {

        try (Socket s = new Socket()) {
            s.connect(new InetSocketAddress("www.psounis.gr", 442), 1000);
            System.out.println("Status of connection: " + s.isConnected());
        } catch (SocketTimeoutException e) {
            System.out.println("Connection time expired!");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}