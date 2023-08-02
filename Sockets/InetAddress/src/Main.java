import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Main {

    public static void print(InetAddress address) {
        System.out.println(address);
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());
        System.out.println(Arrays.toString(address.getAddress()));
        System.out.println("=".repeat(20));
    }

    public static void main(String[] args) {

        try {
            InetAddress address = InetAddress.getLocalHost();
            print(address);

            address = InetAddress.getByName("www.google.com");
            print(address);

            byte[] byteAddress = address.getAddress();
            address = InetAddress.getByAddress(byteAddress);
            print(address);
        }
        catch (UnknownHostException e) {
            System.out.println(e);
        }
    }
}

