import java.io.IOException;
import java.nio.Buffer;
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

        // read utf8 from File
        Path path = Path.of("utf8.bin");
        FileChannel channel = FileChannel.open(path, StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate((int) channel.size());
        channel.read(buffer);
        buffer.flip();
        String s = utf8.decode(buffer).toString();
        System.out.println(s);
        channel.close();


        // read utf16 from File
        path = Path.of("utf16.bin");
        channel = FileChannel.open(path, StandardOpenOption.READ);
        buffer = ByteBuffer.allocate((int) channel.size());
        channel.read(buffer);
        buffer.flip();
        s = utf16.decode(buffer).toString();
        System.out.println(s);
        channel.close();
    }
}