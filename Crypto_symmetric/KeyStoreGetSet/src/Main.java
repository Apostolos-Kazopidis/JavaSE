import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.security.*;
import java.security.cert.*;
import java.util.Base64;

public class Main
{
    public static void main(String[] args) throws KeyStoreException {
        // create a key
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        SecretKey secretKey = keyGenerator.generateKey();
        System.out.println("SecretKey: " + Base64.getEncoder().encodeToString(secretKey.getEncoded()));

        /* 1. Store a new key to the keyStore */
        // load the keystore
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        try (InputStream fis = new FileInputStream("keys.ks")) {
            keyStore.load(fis, "KeyStorePassword".toCharArray());
        } catch (IOException | NoSuchAlgorithmException | CertificateException e) {
            e.printStackTrace();
        }

        //prepare the entry and the password
        KeyStore.SecretKeyEntry entry = new KeyStore.SecretKeyEntry(secretKey);
        KeyStore.PasswordProtection password = new KeyStore.PasswordProtection("passwordForSecretKey".toCharArray());

        //store it to the KeyStore
        keyStore.setEntry("nameForSecretKey", entry, password);

        // Save the keyStore
        try (FileOutputStream fos = new FileOutputStream("keys.ks")) {
            keyStore.store(fos, "KeyStorePassword".toCharArray());
        } catch (NoSuchAlgorithmException | CertificateException | IOException e) {
            e.printStackTrace();
        }

        /* 2. Load the key from keyStore */
        // Load the key from KeyStore
        keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        try(InputStream fis = new FileInputStream("keys.ks")) {
            keyStore.load(fis, "KeyStorePassword".toCharArray());
            entry = (KeyStore.SecretKeyEntry) keyStore.getEntry("nameForSecretKey", password);
            secretKey = entry.getSecretKey();
            System.out.println("SecretKey: " + Base64.getEncoder().encodeToString(secretKey.getEncoded()));
        } catch (IOException | NoSuchAlgorithmException | CertificateException | UnrecoverableEntryException e) {
            e.printStackTrace();
        }

    }
}