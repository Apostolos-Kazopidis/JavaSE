import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.security.cert.CertificateException;

public class Main {

    public static KeyStore getLocalKeyStore(String keyStoreName, String keyStorePassword) throws FileNotFoundException {
        // Load the KeyStore
        KeyStore keyStore = null;
        try {
            keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        try (InputStream fis = new FileInputStream(keyStoreName)) {
            keyStore.load(fis, keyStorePassword.toCharArray());
        } catch (FileNotFoundException e)  {
            throw e;
        }
        catch (IOException | NoSuchAlgorithmException | CertificateException e) {
            e.printStackTrace();
        }
        return keyStore;
    }
    public static KeyStore createKeyStore(String keyStoreName, String keyStorePassword) {
        KeyStore keyStore = null;
        try {
            keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        try (FileOutputStream fos = new FileOutputStream(keyStoreName)) {
            keyStore.load(null, null);
            keyStore.store(fos, keyStorePassword.toCharArray());
        } catch (IOException | NoSuchAlgorithmException | CertificateException | KeyStoreException e) {
            e.printStackTrace();
        }
        return keyStore;
    }
    public static void saveKeyStore(KeyStore keyStore, String keyStoreName, String keyStorePassword) {
        try (FileOutputStream fos = new FileOutputStream(keyStoreName)) {
            keyStore.store(fos, keyStorePassword.toCharArray());
        } catch (NoSuchAlgorithmException | CertificateException | IOException | KeyStoreException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws KeyStoreException {

        // create the keystore (if doesn't exist), else load it
        String keyStoreName = "trusted.ks";
        String keyStorePassword = "ClientKeyStorePassword";
        KeyStore keyStore;
        try {
            keyStore = getLocalKeyStore(keyStoreName, keyStorePassword);
        } catch (FileNotFoundException e) {
            keyStore = createKeyStore(keyStoreName, keyStorePassword);
            saveKeyStore(keyStore, keyStoreName, keyStorePassword);
        }


        TrustManagerFactory trustFactory = null;
        try {
            trustFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustFactory.init(keyStore);
        } catch (NoSuchAlgorithmException | KeyStoreException e) {
            e.printStackTrace();
        }

        // create the context
        SSLContext context = null;
        try {
            context = SSLContext.getInstance("TLS");
            context.init(null,
                    trustFactory.getTrustManagers(),
                    null);
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }
        SSLContext.setDefault(context);


        SSLSocketFactory factory = context.getSocketFactory();

        try (SSLSocket client = (SSLSocket)
                factory.createSocket("127.0.0.1", 12345)) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}