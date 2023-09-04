import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        // make the server and a thread pool
        try (ServerSocket server = new ServerSocket(1234)) {
            ExecutorService es = Executors.newFixedThreadPool(1000);
            System.out.println("Server ready!");

            while (true) {
                // wait for incoming connections
                Socket sockClient = server.accept();

                // assign the socket to a thread
                // Execute a new thread in the thread pool for each incoming connection using es.execute().
                // This allows the server to handle multiple connections concurrently.
                es.execute(() -> {
                    System.out.println("Connection established");
                    //Set up input and output streams for the socket
                    try (InputStream inputStream = sockClient.getInputStream();
                        OutputStream outputStream = new FileOutputStream("logs.xml")) {

                        //Create a byte buffer to read data from the client in chunks
                        byte[] buffer = new byte[1024];

                        while (true) {
                            try {
                                int len = inputStream.read(buffer); //Read data from the input stream into the buffer
                                outputStream.write(buffer, 0, len); //Write the data to an output file named "logs.xml"
                                if (new String(buffer, StandardCharsets.UTF_8).contains("</log>")) //Check if the received data contains the "</log>" tag // If it does, exit the loop, assuming that this marks the end of a log entry
                                    break;
                            }
                            catch(IOException e) {
                                System.out.println(e);
                            }
                        }
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                    System.out.println("Connection closed");
                });
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}