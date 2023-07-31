import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("A.Ba", Pattern.CASE_INSENSITIVE);

        System.out.println(pattern.matcher("abba").matches());

        System.out.println(Pattern.matches(".*", "abba"));

        String escaped = Pattern.quote("ab.*");

        System.out.println(escaped);

        System.out.println(Pattern.matches(escaped, "abab"));

        System.out.println(Pattern.matches(escaped, "ab.*"));
    }
}


