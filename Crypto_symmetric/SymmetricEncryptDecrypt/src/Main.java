import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;
import javax.crypto.*;

public class Main
{
    public static String encrypt(String text, SecretKey key) throws Exception {
        // get the bytes
        byte[] textBytes = text.getBytes();
        // get an instance of the algorithm
        Cipher cipher = Cipher.getInstance("AES");
        // init the algorithm for encryption with the key
        cipher.init(Cipher.ENCRYPT_MODE, key);
        // execute the algorithm
        byte[] encryptedBytes = cipher.doFinal(textBytes);
        // convert the encrypted bytes to text
        Base64.Encoder encoderBytesToText = Base64.getEncoder();
        String encryptedText = encoderBytesToText.encodeToString(encryptedBytes);
        // returned the encrypted text
        return encryptedText;
    }
    public static String decrypt(String encryptedText, SecretKey key) throws Exception {
        // convert the encryptedText to encryptedBytes
        Base64.Decoder decoderTextToBytes = Base64.getDecoder();
        // get the bytes
        byte[] encryptedBytes = decoderTextToBytes.decode(encryptedText);
        // get an instance of the algorithm
        Cipher cipher = Cipher.getInstance("AES");
        // init the algorithm for encryption with the key
        cipher.init(Cipher.DECRYPT_MODE, key);
        // execute the algorithm
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        // convert the decrypted bytes to text
        String decryptedText = new String(decryptedBytes);
        // returned the decrypted text
        return decryptedText;
    }
    public static void main(String[] args) throws Exception {
        // generate the key
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        SecretKey key = keyGenerator.generateKey();

        // encrypt some text
        String initialText = "some text";
        System.out.println("Initial text: " + initialText);
        String encryptedText = encrypt(initialText, key);
        System.out.println("Encrypted text: " + encryptedText);
        String decryptedText = decrypt(encryptedText, key);
        System.out.println("Decrypted text: " + decryptedText);
    }
}