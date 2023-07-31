import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {

        Path path = Path.of("C:\\temp");

        DirectoryStream<Path> contents =
                Files.newDirectoryStream(path,"*.csv");

        for (var item: contents)
            System.out.println(item);

        contents = Files.newDirectoryStream(path,"*.csv");
        contents.forEach(System.out::println);
    }
}