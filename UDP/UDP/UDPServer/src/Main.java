import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
        try (DatagramSocket server = new DatagramSocket(12345)) {
            int counter = 0;

            // accept a request
            DatagramPacket request = new DatagramPacket(new byte[1024], 1024);
            server.receive(request);
            InetAddress clientAddress = request.getAddress();
            int clientPort = request.getPort();
            System.out.println("request received from " + clientAddress + "/" + clientPort);

            while(true) {
                // setup message
                counter++;
                String message = "Message " + counter;
                byte[] bytes = message.getBytes(StandardCharsets.UTF_8);

                // send message
                DatagramPacket response = new DatagramPacket(bytes, bytes.length,
                        clientAddress, clientPort);
                server.send(response);
                Thread.sleep(800);
                System.out.println("Sent " + message);
            }
        } catch (SocketException | InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
