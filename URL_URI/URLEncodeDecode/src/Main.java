import java.net.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {

        try {
            URL url = new URL("http://www.psounis.com/κατάλογος/σελίδα.html");
            System.out.println(url);
            String encodedStr = URLEncoder.encode(url.toString(), StandardCharsets.UTF_8);
            System.out.println(encodedStr);
            String correct =
                    "http://www.psounis.com/" +
                    URLEncoder.encode("κατάλογος", StandardCharsets.UTF_8) +
                    "/" +
                    URLEncoder.encode("σελίδα", StandardCharsets.UTF_8) +
                    ".html";
            URL correctURL = new URL(correct);
            System.out.println(correctURL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
