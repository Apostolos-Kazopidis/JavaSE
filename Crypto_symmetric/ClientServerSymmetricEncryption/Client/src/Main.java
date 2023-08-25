import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
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

        return new SecretKeySpec(keyBytes, 0, keyBytes.length, "AES");
    }

    public static void main(String[] args) {
        try (Socket client = new Socket("127.0.0.1", 1234)) {

            Scanner readFromInput = new Scanner(System.in);
            Scanner readFromServer = new Scanner(client.getInputStream(),
                    StandardCharsets.UTF_8);
            PrintWriter writeToServer = new PrintWriter(client.getOutputStream(),
                    true, StandardCharsets.UTF_8);

            System.out.println("Connection is ready!");
            String secretKeyBase64 = readFromServer.nextLine();
            System.out.println("Read secret key: " + secretKeyBase64);
            SecretKey secretKey = getSecretKeyFromBase64String(secretKeyBase64);

            System.out.println("Client ready!");
            while(true) {
                System.out.print("> ");
                String request = readFromInput.nextLine();
                String encodedRequest = encrypt(request, secretKey);
                System.out.println("Sending: " + encodedRequest + "(encryption of: " + request + ")");
                writeToServer.println(encodedRequest);
                if (request.equals("quit")) {
                    System.out.println("Bye Bye");
                    break;
                }
                String response = readFromServer.nextLine();
                String decodedResponse = decrypt(response, secretKey);
                System.out.println("Server response: " + response + "(decoded: " + decodedResponse + ")");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}