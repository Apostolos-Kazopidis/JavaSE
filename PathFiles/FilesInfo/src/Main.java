import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void print_info(Path path) throws IOException {
        System.out.println("path: " + path);
        System.out.println("is regular file: " + Files.isRegularFile(path));
        System.out.println("is directory: " + Files.isDirectory(path));
        System.out.println("is symbolic link: " + Files.isSymbolicLink(path));

        System.out.println("is hidden: " + Files.isHidden(path));
        System.out.println("size: " + Files.size(path));

        System.out.println("last modified time: " + Files.getAttribute(path, "lastModifiedTime"));
        System.out.println("last access time: " + Files.getAttribute(path, "lastAccessTime"));
        System.out.println("creation time: " + Files.getAttribute(path, "creationTime"));
        System.out.println("=".repeat(20));
    }

    public static void main(String[] args) throws IOException {

        Path basePath = Path.of("C:\\temp");
        print_info(basePath);
        Path file = basePath.resolve("exDir\\temp.txt");
        print_info(file);
        Path link = basePath.resolve("exDir\\link.txt");
        print_info(link);
    }
}