import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("a.b.");

        String str = "abba";
        System.out.println(str + ": " + pattern.matcher(str).matches());
        str = "baba";
        System.out.println(str + ": " + pattern.matcher(str).matches());
        str = "abbaa";
        System.out.println(str + ": " + pattern.matcher(str).matches());
        str = "acbz";
        System.out.println(str + ": " + pattern.matcher(str).matches());
        str = "aaabba";
        System.out.println(str + ": " + pattern.matcher(str).matches());
    }
}


