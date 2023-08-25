import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
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

    public static KeyStore getLocalKeyStore() throws FileNotFoundException {
        // Load the KeyStore
        KeyStore keyStore = null;
        try {
            keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        try (InputStream fis = new FileInputStream("keysServer.ks")) {
            keyStore.load(fis, "ServerKeyStorePassword".toCharArray());
        } catch (FileNotFoundException e)  {
            throw e;
        }
        catch (IOException | NoSuchAlgorithmException | CertificateException e) {
            e.printStackTrace();
        }
        return keyStore;
    }

    public static KeyStore createKeyStore() {
        KeyStore keyStore = null;
        try {
            keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        try (FileOutputStream fos = new FileOutputStream("keysServer.ks")) {
            keyStore.load(null, null);
            keyStore.store(fos, "ServerKeyStorePassword".toCharArray());
        } catch (IOException | NoSuchAlgorithmException | CertificateException | KeyStoreException e) {
            e.printStackTrace();
        }
        return keyStore;
    }


    public static SecretKey createSecretKey() {
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return keyGenerator.generateKey();
    }

    public static void storeSecretKey(KeyStore keyStore, SecretKey secretKey,
                                      String SecretKeyName, String SecretKeyPassword) {
        //prepare the entry and the password
        KeyStore.SecretKeyEntry entry = new KeyStore.SecretKeyEntry(secretKey);
        KeyStore.PasswordProtection password =
                new KeyStore.PasswordProtection(SecretKeyPassword.toCharArray());

        //store it to the KeyStore
        try {
            keyStore.setEntry(SecretKeyName, entry, password);
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
    }

    public static SecretKey loadSecretKey(KeyStore keyStore,
                                   String secretKeyName, String secretKeyPassword) {
        KeyStore.SecretKeyEntry entry = null;

        try {
            keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        try(InputStream fis = new FileInputStream("keys.ks")) {
            keyStore.load(fis, "ServerKeyStorePassword".toCharArray());
            KeyStore.PasswordProtection password =
                    new KeyStore.PasswordProtection(secretKeyPassword.toCharArray());
            entry = (KeyStore.SecretKeyEntry) keyStore.getEntry(secretKeyName, password);
        } catch (IOException | NoSuchAlgorithmException | CertificateException | UnrecoverableEntryException | KeyStoreException e) {
            e.printStackTrace();
        }
        return entry.getSecretKey();
    }

    public static void saveKeyStore(KeyStore keyStore) {
        try (FileOutputStream fos = new FileOutputStream("keys.ks")) {
            keyStore.store(fos, "ServerKeyStorePassword".toCharArray());
        } catch (NoSuchAlgorithmException | CertificateException | IOException | KeyStoreException e) {
            e.printStackTrace();
        }
    }

    public static String secretKeyBase64(SecretKey secretKey) {
        String key = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        return key;
    }

    public static void main(String[] args) {

        KeyStore keyStore;
        SecretKey secretKey;
        try {
            keyStore = getLocalKeyStore();
            secretKey = loadSecretKey(keyStore, "SecretKeyName", "SecretKeyPassword");
        } catch (FileNotFoundException e) {
            keyStore = createKeyStore();
            secretKey = createSecretKey();
            storeSecretKey(keyStore, secretKey, "SecretKeyName", "SecretKeyPassword");
            saveKeyStore(keyStore);
        }
        System.out.println("Secret Key: " + secretKeyBase64(secretKey));



        try (ServerSocket server = new ServerSocket(1234)) {

           System.out.println("Server ready!");
           Socket sockClient = server.accept();

           Scanner readFromClient = new Scanner(sockClient.getInputStream(),
                                                StandardCharsets.UTF_8);
           PrintWriter writeToClient = new PrintWriter(sockClient.getOutputStream(),
                                        true, StandardCharsets.UTF_8);

           writeToClient.println(secretKeyBase64(secretKey)); // send secret key
           System.out.println("Sent secret key");

           while(true) {
               String request = readFromClient.nextLine();
               String decryptedRequest = decrypt(request, secretKey);
               System.out.println("read(encrypted): " + request);
               System.out.println("read(decrypted): " + decryptedRequest);
               if (decryptedRequest.equals("quit")) {
                   System.out.println("Client is done!");
                   break;
               }
               String response = "<server echoing: " + decryptedRequest + ">";
               String encryptedResponse = encrypt(response, secretKey);
               writeToClient.println(encryptedResponse);
               System.out.println("Sending: " + response + "(encrypted as: " + encryptedResponse + ")");
           }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
