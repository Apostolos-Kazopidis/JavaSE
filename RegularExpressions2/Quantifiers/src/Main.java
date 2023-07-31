import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void splitter(String text, String regex) {
        Matcher m = Pattern.compile(regex).matcher(text);

        System.out.println("-".repeat(30));
        while(m.find()) {
            System.out.println(m.group());
        }
        System.out.println("Splitted " + Arrays.toString(text.split(regex)));
        System.out.println("-".repeat(30));
    }

    public static void main(String[] args) {
        System.out.println("abb".matches("ab+"));
        System.out.println("abb".matches("ab{3,}"));
        System.out.println("abab".matches("(ab){2}"));
        System.out.println("abab".matches("(ab){3}"));

        splitter("XabbXaX", "ab+");
    }
}


