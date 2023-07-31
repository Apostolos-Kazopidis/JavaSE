import java.io.File;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        // absolute
        Path p = Path.of("D:","Java-Psounis","Java-SE","lesson5_03");
        System.out.println(p);
        File f = new File(p.toUri());
        System.out.println(f);
        Path p2 = Path.of(f.toURI());
        System.out.println(p2);

        // relative
        p = Path.of("..");
        System.out.println(p);
        System.out.println(p.toUri());
        f = new File(p.toUri());
        System.out.println(f);
        p2 = Path.of(f.toURI());
        System.out.println(p2);
    }
}