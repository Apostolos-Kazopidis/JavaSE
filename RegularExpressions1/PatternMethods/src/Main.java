import java.util.Arrays;
import java.util.function.Predicate;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("A.Ba", Pattern.CASE_INSENSITIVE);
        System.out.println(pattern.pattern());

        Pattern pattern2 = Pattern.compile("bc");
        System.out.println(Arrays.toString(pattern2.split("aabcribcbcdibca")));

        Predicate<String> pred = pattern.asPredicate();
        System.out.println(pred.test("aaba"));

    }
}


