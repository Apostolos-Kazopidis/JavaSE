import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        Charset utf8 = StandardCharsets.UTF_8;
        Charset utf16 = StandardCharsets.UTF_16;

        // write utf8 to a File
        ByteBuffer buffer = utf8.encode("English Ελληνικά \uD801\uDC37");
        System.out.println(Arrays.toString(buffer.array()));

        Path path = Path.of("utf8.bin");
        FileChannel channel = FileChannel.open(path,
                StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        channel.write(buffer);
        channel.close();

        // write utf16 to a File
        buffer = utf16.encode("English Ελληνικά \uD801\uDC37");
        System.out.println(Arrays.toString(buffer.array()));

        path = Path.of("utf16.bin");
        channel = FileChannel.open(path,
                StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        channel.write(buffer);
        channel.close();
    }
}