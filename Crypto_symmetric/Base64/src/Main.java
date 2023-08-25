import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

public class Main
{
    public static void main(String[] args)
    {
        String plainText = "Man";

        Base64.Encoder encoder = Base64.getEncoder();
        Base64.Decoder decoder = Base64.getDecoder();

        byte[] ASCIIBytes = plainText.getBytes(StandardCharsets.US_ASCII);
        System.out.println("Initial Bytes: " + Arrays.toString(ASCIIBytes));

        String encodedText = encoder.encodeToString(ASCIIBytes);
        System.out.println("Encoded Text: " + encodedText);

        byte[] decodedBytes = decoder.decode(encodedText);
        System.out.println("Decoded Bytes: " + Arrays.toString(decodedBytes));

        String decodedText = new String(decodedBytes,StandardCharsets.US_ASCII);
        System.out.println("Decoded Text: " + decodedText);
    }
}