import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {

        Charset utf8 = Charset.forName("UTF-8");
        Charset utf8_2 = StandardCharsets.UTF_8;
        System.out.println(utf8.equals(utf8_2));

        System.out.println(utf8.contains(StandardCharsets.US_ASCII));
        System.out.println(utf8.name());
    }
}