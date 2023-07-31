import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Pattern re = Pattern.compile("pattern");
        Matcher matcher = re.matcher("string");
        System.out.println(matcher.matches());

        re = Pattern.compile("pattern");
        matcher = re.matcher("pattern");
        System.out.println(matcher.matches());
    }
}


