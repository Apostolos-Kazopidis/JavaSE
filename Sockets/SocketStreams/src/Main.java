import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Socket s = new Socket("www.google.com", 80) ;
             Scanner in = new Scanner(s.getInputStream()) ;
             DataOutputStream out = new DataOutputStream(s.getOutputStream())) {

            out.writeUTF("Hello Google!");

            String response = in.nextLine();
            System.out.println(response);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}