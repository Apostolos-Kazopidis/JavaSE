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

            Matcher m = Pattern.compile("<a href=\"(.*?\\.(\\w*?))\">(.*?)</a>").matcher(text);

            while(m.find())
                System.out.println(
                        "found       : " + m.group() + "\n" +
                        " links to   : " + m.group(1) + "\n" +
                        " link type  : " + m.group(2) + "\n" +
                        " description: " + m.group(3) + "\n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}


