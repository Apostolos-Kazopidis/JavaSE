import javax.net.ssl.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static KeyStore getLocalKeyStore() throws FileNotFoundException {
        // Load the KeyStore
        KeyStore keyStore = null;
        try {
            keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        try (InputStream fis = new FileInputStream("trusted.ks")) {
            keyStore.load(fis, "ClientKeyStorePassword".toCharArray());
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
        try (FileOutputStream fos = new FileOutputStream("trusted.ks")) {
            keyStore.load(null, null);
            keyStore.store(fos, "ClientKeyStorePassword".toCharArray());
        } catch (IOException | NoSuchAlgorithmException | CertificateException | KeyStoreException e) {
            e.printStackTrace();
        }
        return keyStore;
    }
    public static void saveKeyStore(KeyStore keyStore) {
        try (FileOutputStream fos = new FileOutputStream("trusted.ks")) {
            keyStore.store(fos, "ClientKeyStorePassword".toCharArray());
        } catch (NoSuchAlgorithmException | CertificateException | IOException | KeyStoreException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws KeyStoreException {

        // create the keystore (if doesn't exist), else load it
        KeyStore keyStore;
        try {
            keyStore = getLocalKeyStore();
        } catch (FileNotFoundException e) {
            keyStore = createKeyStore();
            saveKeyStore(keyStore);
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

            Scanner readFromInput = new Scanner(System.in);
            Scanner readFromServer = new Scanner(client.getInputStream(),
                    StandardCharsets.UTF_8);
            PrintWriter writeToServer = new PrintWriter(client.getOutputStream(),
                    true, StandardCharsets.UTF_8);


            System.out.println("Client ready!");
            System.out.println(client.getSession().getCipherSuite());
            System.out.println(Arrays.toString(client.getSession().getPeerCertificates()));

            while(true) {
                System.out.print("> ");
                String request = readFromInput.nextLine();
                System.out.println("Sending: " + request);
                writeToServer.println(request);
                if (request.equals("quit")) {
                    System.out.println("Bye Bye");
                    break;
                }
                String response = readFromServer.nextLine();
                System.out.println("Server response: " + response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}