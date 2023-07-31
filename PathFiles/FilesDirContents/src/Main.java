import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        Path path = Path.of("C:\\temp");

        Stream<Path> contents = Files.list(path);

        contents.forEach(p->{
            if (Files.isDirectory(p)) System.out.print("Dir : ");
            else System.out.print("File: ");
            System.out.println(p);
        });


        System.out.println("=".repeat(30));


        contents = Files.walk(path);

        contents.forEach(p->{
            if (Files.isDirectory(p)) System.out.print("Dir : ");
            else System.out.print("File: ");
            System.out.println(p);
        });


    }
}