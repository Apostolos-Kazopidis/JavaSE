import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    public static void print_status(Socket s) {
        System.out.println("Connected: " + s.isConnected());
        System.out.println("Closed: " + s.isClosed());
        System.out.println("InputStream shutdown: " + s.isInputShutdown());
        System.out.println("OutputStream shutdown: " + s.isOutputShutdown());
    }

    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(1234)) {

           System.out.println("Server ready!");
           Socket sockClient = server.accept();

           Scanner readFromClient = new Scanner(sockClient.getInputStream(),
                                                StandardCharsets.UTF_8);
           PrintWriter writeToClient = new PrintWriter(sockClient.getOutputStream(),
                                        true, StandardCharsets.UTF_8);

           while(true) {
               String request = readFromClient.nextLine();
               System.out.println("read: " + request);
               if (request.equals("quit")) {
                   System.out.println("Client is done!");
                   break;
               }
               String response = "<server echoing: " + request + ">";
               writeToClient.println(response);
           }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}