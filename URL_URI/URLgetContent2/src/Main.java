import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.nio.CharBuffer;

public class Main {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.psounis.gr/plh20.html");
            Class<?>[] classes = new Class[3];
            classes[0] = String.class;
            classes[1] = InputStream.class;
            classes[2] = CharBuffer.class;
            Object object = url.getContent(classes);
            System.out.println(object.getClass());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
