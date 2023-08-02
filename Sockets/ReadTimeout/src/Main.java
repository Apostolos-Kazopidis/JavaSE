import java.io.DataOutputStream;
import java.net.Socket;
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

            s.setSoTimeout(10);
            out.writeUTF("Hello there!");
            System.out.println(in.nextLine());
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}