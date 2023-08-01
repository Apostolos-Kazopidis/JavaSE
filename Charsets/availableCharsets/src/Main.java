import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args) {

        System.out.println(Charset.defaultCharset());
        System.out.println("=".repeat(20));

        var charsets = Charset.availableCharsets();
        for (var charset: charsets.entrySet())
            System.out.println(charset.getKey() + " " + charset.getValue());

    }
}