import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String text =   "Everything about me is a contradiction, " +
                        "and so is everything about everybody else. " +
                        "We are made out of oppositions; we live between two poles. " +
                        "There's a philistine and an aesthete in all of us, " +
                        "and a murderer and a saint. You don't reconcile the poles. " +
                        "You just recognize them.";

        System.out.println(text.matches(".*saint.*"));

        System.out.println(Arrays.toString(text.split(" ")));

        System.out.println(Arrays.toString(text.split(" a.* ")));

        System.out.println(text.replaceAll("a..", "XXX"));

    }
}


