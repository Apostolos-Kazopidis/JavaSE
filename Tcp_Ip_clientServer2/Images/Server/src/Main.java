import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(1234)) {

            System.out.println("Server ready!");
            Socket sockClient = server.accept();
            System.out.println(sockClient.getSendBufferSize() + " " + sockClient.getReceiveBufferSize());
            sockClient.setSendBufferSize(131072);
            sockClient.setReceiveBufferSize(1024);

            Scanner readFromClient = new Scanner(sockClient.getInputStream(),
                    StandardCharsets.UTF_8);
            BufferedOutputStream writeToClient = new BufferedOutputStream(
                    sockClient.getOutputStream(), 131072);
            System.out.println("Buffer size: SocketSend: " + sockClient.getSendBufferSize());
            String username = readFromClient.nextLine();
            while(true) {
                String request = readFromClient.nextLine();
                System.out.println(username + " requested: " + request);
                if (request.equals("quit")) {
                    System.out.println("Client is done!");
                    break;
                }

                byte[] contents = Files.readAllBytes(Path.of(request));
                System.out.println();
                writeToClient.write(ByteBuffer.allocate(4).putInt(contents.length).flip().array());
                writeToClient.write(contents);
                writeToClient.flush();
                System.out.println("sent " + contents.length + " bytes");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}