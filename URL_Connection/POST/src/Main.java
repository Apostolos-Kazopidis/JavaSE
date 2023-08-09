import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://httpbin.org/post");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            try (DataOutputStream out =
                         new DataOutputStream(connection.getOutputStream())) {
                out.writeUTF("custemail=psounis@gmail.com&custname=psounis");
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (Scanner sc = new Scanner(connection.getInputStream())) {
                while (sc.hasNext())
                    System.out.println(sc.nextLine());
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
