import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.sql.SQLOutput;
import java.util.Base64;
import java.util.Scanner;

public class Main {


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

    public static SecretKey getSecretKeyFromBase64String(String secretKeyBase64) {
        byte[] keyBytes = Base64.getDecoder().decode(secretKeyBase64);

        return new SecretKeySpec(keyBytes, 0, keyBytes.length, "AES"); // stackoverflow
    }

    public static PublicKey decodePublicKey(byte[] publicKeyBytes) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(publicKeyBytes)); // stackoverflow
    }

    public static String encodeBytesBase64(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }
    public static byte[] decodeStringBase64(String base64) {
        return Base64.getDecoder().decode(base64);
    }

    public static byte[] encryptSessionKeyWithPublicKey(SecretKey secretKey, PublicKey publicKey) throws Exception {
        byte[] textBytes = secretKey.getEncoded();
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(textBytes);
    }

    public static SecretKey createSessionKey() {
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return keyGenerator.generateKey();
    }


    public static void main(String[] args) {
        try (Socket client = new Socket("127.0.0.1", 1234)) {

            Scanner readFromInput = new Scanner(System.in);
            Scanner readFromServer = new Scanner(client.getInputStream(),
                    StandardCharsets.UTF_8);
            PrintWriter writeToServer = new PrintWriter(client.getOutputStream(),
                    true, StandardCharsets.UTF_8);

            // read public key
            System.out.println("Connection is ready!");
            String publicKeyBase64 = readFromServer.nextLine();
            byte[] publicKeyBytes = decodeStringBase64(publicKeyBase64);
            PublicKey publicKey = decodePublicKey(publicKeyBytes);

            // create session key with public key, and send it to server
            SecretKey sessionKey = createSessionKey();
            byte[] encryptedSessionKey = encryptSessionKeyWithPublicKey(sessionKey, publicKey);
            String encodedEncryptedSessionKey = encodeBytesBase64(encryptedSessionKey);
            writeToServer.println(encodedEncryptedSessionKey);

            System.out.println("Client ready!");
            while(true) {
                System.out.print("> ");
                String request = readFromInput.nextLine();
                String encodedRequest = encrypt(request, sessionKey);
                System.out.println("Sending: " + encodedRequest + "(encryption of: " + request + ")");
                writeToServer.println(encodedRequest);
                if (request.equals("quit")) {
                    System.out.println("Bye Bye");
                    break;
                }
                String response = readFromServer.nextLine();
                String decodedResponse = decrypt(response, sessionKey);
                System.out.println("Server response: " + response + "(decoded: " + decodedResponse + ")");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}