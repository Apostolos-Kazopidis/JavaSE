import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(
                "psounis21@gmail.com".
                        matches("[a-zA-Z1-9]{8,12}@gmail.com"));
        System.out.println(
                "1.psounis@gmail.com".
                        matches("[a-zA-Z1-9]{8,12}@gmail.com"));
        System.out.println(
                "psounis-21@gmail.com".
                        matches("[a-zA-Z0-9_-]+@[a-zA-Z_-]+\\.com"));
        String text =   "Everything about me is a contradiction, " +
                "and so is everything about everybody else. " +
                "We are made out of oppositions; we live between two poles. " +
                "There's a philistine and an aesthete in all of us, " +
                "and a murderer and a saint. You don't reconcile the poles. " +
                "You just recognize them.";

        System.out.println(Arrays.toString(text.split("[.,;]? ")));

    }
}


