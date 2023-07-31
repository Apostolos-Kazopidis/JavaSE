public class Main {
    public static void main(String[] args) {
        System.out.println("\\\\".matches("\\\\{2,}")); // "\" is written re:"\\\\"

        String text =   "Everything about me is a contradiction, " +
                "and so is everything about everybody else. \n" +
                "We are made out of oppositions; we live between two poles. \n" +
                "There's a philistine and an aesthete in all of us, \n" +
                "and a murderer and a saint. You don't reconcile the poles. \n" +
                "You just recognize them.";

        String[] phrases = text.split("\\n *");
        for (var phrase: phrases) {
            System.out.println(phrase);
        }

    }
}