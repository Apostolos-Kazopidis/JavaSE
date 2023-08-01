import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Charset utf8 = StandardCharsets.UTF_8;

        String data = "English Ελληνικά \uD801\uDC37\n是\uD83D\uDE03";
        Path path = Path.of("utf8.bin");

        // write a utf-8 file
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(
                new FileWriter(path.toFile(), utf8)))) {
            pw.print(data);
        }
        catch (IOException e) {
            System.out.println(e);
        }

        // read a utf-8 file
        try (BufferedReader br = new BufferedReader(
                new FileReader(path.toFile(), utf8))) {
            String s;
            while ((s=br.readLine()) != null) {
                System.out.println(s);
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }

        // read a utf-8 file - as string (Files class)
        try {
            String s = Files.readString(path, utf8);
            System.out.println(s);
        }
        catch (IOException e) {
            System.out.println(e);
        }

        // read a utf-8 file - as string (Files class)
        try {
            List<String> s = Files.readAllLines(path, utf8);
            System.out.println(s);
        }
        catch (IOException e) {
            System.out.println(e);
        }

    }
}