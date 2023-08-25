import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.*;
import java.io.*;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.*;

public class Main {


    public static KeyStore getLocalKeyStore(String name, String password) throws FileNotFoundException {
        // Load the KeyStore
        KeyStore keyStore = null;
        try {
            keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        try (InputStream fis = new FileInputStream(name)) {
            keyStore.load(fis, password.toCharArray());
        } catch (FileNotFoundException e)  {
            throw e;
        }
        catch (IOException | NoSuchAlgorithmException | CertificateException e) {
            e.printStackTrace();
        }
        return keyStore;
    }
    public static KeyStore createKeyStore(String name, String password) {
        KeyStore keyStore = null;
        try {
            keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        try (FileOutputStream fos = new FileOutputStream(name)) {
            keyStore.load(null, null);
            keyStore.store(fos, password.toCharArray());
        } catch (IOException | NoSuchAlgorithmException | CertificateException | KeyStoreException e) {
            e.printStackTrace();
        }
        return keyStore;
    }
    public static void saveKeyStore(KeyStore keyStore, String name, String password) {
        try (FileOutputStream fos = new FileOutputStream(name)) {
            keyStore.store(fos, password.toCharArray());
        } catch (NoSuchAlgorithmException | CertificateException | IOException | KeyStoreException e) {
            e.printStackTrace();
        }
    }

    public static KeyPair createKeyPair() {
        KeyPairGenerator keyPairGenerator = null;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        return keyPair;
    }
    public static void storeKeyPairAndCertificate(KeyStore keyStore, KeyPair keyPair,
                                      String privateKeyName, String privateKeyPassword) {

        //create the certificate:
        Certificate cert = null;
        try {
            String subjectDN = "CN=Jim Psounis," +
                    "SURNAME=Psounis," +
                    "SERIALNUMBER=213243-1234," +
                    "C=SE," +
                    "DC=psounis.com";
            cert = selfSign(keyPair, subjectDN);
        } catch (OperatorCreationException | IOException | CertificateException e) {
            e.printStackTrace();
        }

        KeyStore.PrivateKeyEntry entry = new KeyStore.PrivateKeyEntry(keyPair.getPrivate(), new Certificate[] {cert});
        KeyStore.PasswordProtection password =
                new KeyStore.PasswordProtection(privateKeyPassword.toCharArray());

        //store it to the KeyStore
        try {
            keyStore.setEntry(privateKeyName, entry, password);
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }

        // Make an Additional entry for the certificate
        Certificate certificate =
                loadCertificate(keyStore, "PrivateKeyName", "ServerKeyStorePassword");

        KeyStore.TrustedCertificateEntry certEntry = new KeyStore.TrustedCertificateEntry(certificate);
        try {
            keyStore.setEntry("Certificate",certEntry,null);
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
    }

    public static PrivateKey loadPrivateKey(KeyStore keyStore,
                                   String privateKeyName, String privateKeyPassword) {

        KeyStore.PasswordProtection password =
                new KeyStore.PasswordProtection(privateKeyPassword.toCharArray());
        KeyStore.PrivateKeyEntry entry = null;

        try {
            entry = (KeyStore.PrivateKeyEntry) keyStore.getEntry(privateKeyName, password);
        } catch (NoSuchAlgorithmException | KeyStoreException | UnrecoverableEntryException e) {
            e.printStackTrace();
        }

        return entry.getPrivateKey();
    }
    public static Certificate loadCertificate(KeyStore keyStore,
                                            String privateKeyName, String privateKeyPassword) {
        KeyStore.PrivateKeyEntry entry = null;

        KeyStore.PasswordProtection password =
                new KeyStore.PasswordProtection(privateKeyPassword.toCharArray());
        try {
            entry = (KeyStore.PrivateKeyEntry) keyStore.getEntry(privateKeyName, password);
        } catch (NoSuchAlgorithmException | UnrecoverableEntryException | KeyStoreException e) {
            e.printStackTrace();
        }
        return entry.getCertificate();
    }
    public static Certificate selfSign(KeyPair keyPair, String subjectDN) throws OperatorCreationException, CertificateException, IOException
    {
        Provider bcProvider = new BouncyCastleProvider();
        Security.addProvider(bcProvider);

        long now = System.currentTimeMillis();
        Date startDate = new Date(now);

        X500Name dnName = new X500Name(subjectDN);
        BigInteger certSerialNumber = new BigInteger(Long.toString(now)); // <-- Using the current timestamp as the certificate serial number

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.YEAR, 1); // <-- 1 Yr validity

        Date endDate = calendar.getTime();

        String signatureAlgorithm = "SHA1withRSA"; // <-- Use appropriate signature algorithm based on your keyPair algorithm.

        ContentSigner contentSigner = new JcaContentSignerBuilder(signatureAlgorithm).build(keyPair.getPrivate());

        JcaX509v3CertificateBuilder certBuilder = new JcaX509v3CertificateBuilder(dnName, certSerialNumber, startDate, endDate, dnName, keyPair.getPublic());

        // Extensions --------------------------

        // Basic Constraints
        BasicConstraints basicConstraints = new BasicConstraints(true); // <-- true for CA, false for EndEntity

        certBuilder.addExtension(new ASN1ObjectIdentifier("2.5.29.19"), true, basicConstraints); // Basic Constraints is usually marked as critical.

        // -------------------------------------

        return new JcaX509CertificateConverter().setProvider(bcProvider).getCertificate(certBuilder.build(contentSigner));
    }


    public static void main(String[] args) {

        // create the keystore and the keypair (if they don't exist), else load them
        String keyStoreFileName = "keys.ks";
        String keyStorePassword = "ServerKeyStorePassword";
        KeyStore keyStore;
        try {
            keyStore = getLocalKeyStore(keyStoreFileName, keyStorePassword);
        } catch (FileNotFoundException e) {
            keyStore = createKeyStore(keyStoreFileName, keyStorePassword);
            KeyPair keyPair = createKeyPair();

            storeKeyPairAndCertificate(keyStore, keyPair,
                    "PrivateKeyName", "ServerKeyStorePassword");
            saveKeyStore(keyStore, keyStoreFileName, keyStorePassword);
        }



        // key manager factory
        KeyManagerFactory keyManagerFactory = null;
        try {
            keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, "ServerKeyStorePassword".toCharArray());
        } catch (NoSuchAlgorithmException | KeyStoreException | UnrecoverableKeyException e) {
            e.printStackTrace();
        }

        // create the context
        SSLContext context = null;
        try {
            context = SSLContext.getInstance("TLS");
            context.init(keyManagerFactory.getKeyManagers(),
                    null, //trustFactory.getTrustManagers(),
                    null);
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }



        // get the SSLServerSocketFactory from context
        SSLServerSocketFactory factory = context.getServerSocketFactory();

        try (SSLServerSocket server = (SSLServerSocket)
                factory.createServerSocket(12345)) {

            server.setEnabledProtocols(new String[] {"TLSv1.2"});
            server.setEnabledCipherSuites(new String[] {
                    "TLS_RSA_WITH_AES_256_GCM_SHA384",
                    "TLS_RSA_WITH_AES_128_GCM_SHA256"
            });
            System.out.println("Server ready!");

            SSLSocket sockClient = (SSLSocket) server.accept();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
