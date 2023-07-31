import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("ab.");

        Matcher matcher = pattern.matcher("abcioiabbaac");

        while(matcher.find())
            System.out.println("start: " + matcher.start() +
                    ", end: " + matcher.end());
    }
}


