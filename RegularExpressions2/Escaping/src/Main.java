public class Main {
    public static void main(String[] args) {
        System.out.println("a+aa".matches("a+a+"));

        System.out.println("a+ba".matches("a\\+.a+"));

        String text =   "Everything about me is a contradiction, " +
                "and so is everything about everybody else. " +
                "We are made out of oppositions; we live between two poles. " +
                "There's a philistine and an aesthete in all of us, " +
                "and a murderer and a saint. You don't reconcile the poles. " +
                "You just recognize them.";

        String[] phrases = text.split("\\. *");

        for (var phrase: phrases) {
            System.out.println(phrase);
        }

    }
}


