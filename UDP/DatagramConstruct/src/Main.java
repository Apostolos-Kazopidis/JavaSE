import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
        String message = "Winter is coming...";
        byte[] bytes = message.getBytes(StandardCharsets.UTF_8);

        try {
            DatagramPacket datagram = new DatagramPacket(bytes, bytes.length,
                    InetAddress.getLocalHost(), 12345);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
