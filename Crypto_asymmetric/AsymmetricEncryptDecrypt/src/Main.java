import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;
import javax.crypto.*;

public class Main
{
    public static String serverEncrypt(String text, PrivateKey key) throws Exception {
        byte[] textBytes = text.getBytes();
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(textBytes);
        Base64.Encoder encoderBytesToText = Base64.getEncoder();
        return encoderBytesToText.encodeToString(encryptedBytes);
    }
    public static String serverDecrypt(String encryptedText, PrivateKey key) throws Exception {
        Base64.Decoder decoderTextToBytes = Base64.getDecoder();
        byte[] encryptedBytes = decoderTextToBytes.decode(encryptedText);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }
    public static String clientEncrypt(String text, PublicKey key) throws Exception {
        byte[] textBytes = text.getBytes();
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(textBytes);
        Base64.Encoder encoderBytesToText = Base64.getEncoder();
        return encoderBytesToText.encodeToString(encryptedBytes);
    }
    public static String clientDecrypt(String encryptedText, PublicKey key) throws Exception {
        Base64.Decoder decoderTextToBytes = Base64.getDecoder();
        byte[] encryptedBytes = decoderTextToBytes.decode(encryptedText);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }

    public static void main(String[] args) throws Exception {
        // generate the keys
        KeyPairGenerator keyPairGenerator = null;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        // Server sends - Client Receives
        String serverText = "server text";
        System.out.println("Server: Initial text: " + serverText);
        String serverEncryptedText = serverEncrypt(serverText, privateKey);
        System.out.println("Server: Encrypted text: " + serverEncryptedText);
        String clientDecryptedText = clientDecrypt(serverEncryptedText, publicKey);
        System.out.println("Client: Decrypted text: " + clientDecryptedText);
        System.out.println("===============================");
        // Client sends - Server Receives
        String clientText = "client text";
        System.out.println("Client: Initial text: " + clientText);
        String clientEncryptedText = clientEncrypt(clientText, publicKey);
        System.out.println("Client: Encrypted text: " + clientEncryptedText);
        String serverDecryptedText = serverDecrypt(clientEncryptedText, privateKey);
        System.out.println("Server: Decrypted text: " + serverDecryptedText);

    }
}