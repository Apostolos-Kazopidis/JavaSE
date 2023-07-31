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
    }

    public static void main(String[] args) {
        splitter("abbx", "a.+");
        splitter("abbx", "a.+?");
        splitter("abbxx", "a.++x"); 

        String text =   "Everything about me is a contradiction, " +
                "and so is everything about everybody else. " +
                "We are made out of oppositions; we live between two poles. " +
                "There's a philistine and an aesthete in all of us, " +
                "and a murderer and a saint. You don't reconcile the poles. " +
                "You just recognize them.";

        System.out.println(Arrays.toString(
                text.split(" ")));
        System.out.println(Arrays.toString(
                text.split(" a.*? ")));

    }
}


