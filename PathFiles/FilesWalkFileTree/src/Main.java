/* Edits to the original source code from
   https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/nio/file/FileVisitor.html */
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {

    public static void dirCopy(Path source, Path target) throws IOException {
        Files.walkFileTree(source,
                new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                            throws IOException
                    {
                        Path targetdir = target.resolve(source.relativize(dir));
                        try {
                            Files.copy(dir, targetdir);
                        } catch (FileAlreadyExistsException e) {
                            if (!Files.isDirectory(targetdir))
                                throw e;
                        }
                        return FileVisitResult.CONTINUE;
                    }
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                            throws IOException
                    {
                        Files.copy(file, target.resolve(source.relativize(file)));
                        return FileVisitResult.CONTINUE;
                    }
                });
    }

    public static void dirDelete(Path dir) throws IOException {
        Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException
            {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }
            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException e)
                    throws IOException
            {
                if (e == null) {
                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                } else {
                    // directory iteration failed
                    throw e;
                }
            }
        });
    }

    public static void main(String[] args) throws IOException {

        //dirCopy(Path.of("C:\\temp"),Path.of("C:\\temp2"));
        dirDelete(Path.of("C:\\temp2"));
    }
}