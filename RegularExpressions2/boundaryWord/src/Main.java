import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        File f = new File("pies.html");
        String text;
        try (Scanner sc = new Scanner(f)) {

            text = sc.useDelimiter("\\A").next();

            Matcher m = Pattern.compile("\\bπίτες\\b").matcher(text);

            int i=0;
            while(m.find()) {
                i++;
                System.out.println(i + ": " + m.group() + ": " + m.start() + "-" + m.end());
            }



            m = Pattern.compile("(.*?)(\\Bπιτες\\b)").matcher(text);

            i=0;
            while(m.find()) {
                i++;
                System.out.println(i + ": " + m.group(2) + ": " + m.start() + "-" + m.end());
                System.out.println(m.group(1));
            }


            text =  "Everything about me is a contradiction, " +
                    "and so is everything about everybody else. " +
                    "We are made out of oppositions; we live between two poles. " +
                    "There's a philistine and an aesthete in all of us, " +
                    "and a murderer and a saint. You don't reconcile the poles. " +
                    "You just recognize them.";

            m = Pattern.compile("\\ba.*?\\b",Pattern.CASE_INSENSITIVE).matcher(text);

            i=0;
            while(m.find()) {
                i++;
                System.out.println(i + ": " + m.group());
            }







        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}


