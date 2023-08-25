import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            socket.setSoTimeout(5000);
            DatagramPacket request = new DatagramPacket(
                    new byte[0], 0, //empty packet
                    InetAddress.getByName("djxmmx.net"), 17);
            socket.send(request);

            DatagramPacket response = new DatagramPacket(new byte[8192], 8192);
            socket.receive(response);
            System.out.println(new String(response.getData(), StandardCharsets.UTF_8));
        } catch (SocketException | UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
