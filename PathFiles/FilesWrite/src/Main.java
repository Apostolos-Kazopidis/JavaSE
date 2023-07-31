import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        String s = "A line\nAnother line\n";

        Path path = Path.of("some_text.txt");
        Files.writeString(path, s);

        Files.write(path,
                List.of("Line3", "Line4"),
                StandardOpenOption.APPEND);

    }
}