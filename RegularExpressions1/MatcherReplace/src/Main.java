import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Pattern pattern =
                Pattern.compile("ab.");
        Matcher matcher =
                pattern.matcher("abcioiabbaac");

        String replaced = matcher.replaceFirst("XXX");
        String replacedAll = matcher.replaceAll("XXX");

        System.out.println(replaced + "\n" +  replacedAll);

    }
}


