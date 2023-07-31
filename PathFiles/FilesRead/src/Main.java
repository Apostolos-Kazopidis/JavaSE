import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Path path = Path.of("some_text.txt");
        String s = Files.readString(path);
        System.out.println(s);

        System.out.println("=".repeat(30));
        List<String> list = Files.readAllLines(path);
        for (var string: list)
            System.out.println(string);
    }
}