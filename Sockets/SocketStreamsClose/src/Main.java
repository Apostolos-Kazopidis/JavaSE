import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

    public static void print_status(Socket s) {
        System.out.println("Connected: " + s.isConnected());
        System.out.println("Closed: " + s.isClosed());
        System.out.println("InputStream shutdown: " + s.isInputShutdown());
        System.out.println("OutputStream shutdown: " + s.isOutputShutdown());
    }

    public static void main(String[] args) {

        try (Socket s = new Socket("www.google.com", 80) ;
             Scanner in = new Scanner(s.getInputStream()) ;
             DataOutputStream out = new DataOutputStream(s.getOutputStream())) {

            print_status(s);
            s.shutdownInput();
            print_status(s);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}