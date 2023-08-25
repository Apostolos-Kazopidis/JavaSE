import java.io.*;
import java.security.*;
import java.security.cert.*;

public class Main
{

    public static void main(String[] args) throws KeyStoreException {
        // Create the KeyStore (with a password)
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        try (FileOutputStream fos = new FileOutputStream("keys.ks")) {
            keyStore.load(null, null);
            keyStore.store(fos, "KeyStorePassword".toCharArray());
        } catch (IOException | NoSuchAlgorithmException | CertificateException e) {
            e.printStackTrace();
        }

        // Load the KeyStore
        try (InputStream fis = new FileInputStream("keys.ks")) {
            keyStore.load(fis, "KeyStorePassword".toCharArray());
        } catch (IOException | NoSuchAlgorithmException | CertificateException e) {
            e.printStackTrace();
        }

        // Store something to KeyStore
        try (FileOutputStream fos = new FileOutputStream("keys.ks")) {
            // do something to KeyStore (e.g. store Key)
            keyStore.store(fos, "KeyStorePassword".toCharArray());
        } catch (IOException | NoSuchAlgorithmException | CertificateException e) {
            e.printStackTrace();
        }

    }
}
