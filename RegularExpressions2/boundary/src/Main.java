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

            Matcher m = Pattern.compile("^\s*?<(.+?)>", Pattern.MULTILINE).
                    matcher(text);

            int i=0;
            while(m.find()) {
                i++;
                System.out.println(i + ": " + m.group(1));
            }


            m = Pattern.compile("\\A<!DOCTYPE (.*?)>").matcher(text);

            if(m.find())
                System.out.println("doctype: " + m.group(1));



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}


