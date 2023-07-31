import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args){

        try {
            Path basePath = Path.of("C:\\temp");

            // try to delete a non-empty directory
            try {
                Files.delete(basePath);
            }
            catch (DirectoryNotEmptyException e) {
                System.out.println(basePath + " is not empty!");
            }

            // delete an empty directory
            try {
                Path dirToDelete = basePath.resolve("1\\2\\3");
                Files.delete(dirToDelete);
                System.out.println(dirToDelete + " deleted!");
            }
            catch (DirectoryNotEmptyException e) {
                e.printStackTrace();
            }

            // copy a file
            Path aFile = basePath.resolve("exDir\\temp.txt");
            Path newFile = basePath.resolve("exDir\\temp2.txt");

            Files.copy(aFile, newFile);

            // move a file
            Files.move(newFile, basePath.resolve("temp.txt"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}