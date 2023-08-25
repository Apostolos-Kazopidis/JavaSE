import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
        try (DatagramChannel channel = DatagramChannel.open()) {
            // prepare message
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put("Hey Server!".getBytes(StandardCharsets.UTF_8));
            buffer.flip();

            //send it
            SocketAddress serverAddress =
                    new InetSocketAddress(InetAddress.getByName("djxmmx.net"), 17);
            channel.send(buffer, serverAddress);

            //receive the answer
            buffer.clear();
            channel.receive(buffer);
            //decode it
            buffer.flip();
            String response = StandardCharsets.UTF_8.decode(buffer).toString();
            System.out.println("Server response: " + response);
        } catch (SocketException | UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
