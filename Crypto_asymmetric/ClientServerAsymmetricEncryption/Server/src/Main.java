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
import java.io.*;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
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
        try (InputStream fis = new FileInputStream("keys.ks")) {
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
        try (FileOutputStream fos = new FileOutputStream("keys.ks")) {
            keyStore.load(null, null);
            keyStore.store(fos, "ServerKeyStorePassword".toCharArray());
        } catch (IOException | NoSuchAlgorithmException | CertificateException | KeyStoreException e) {
            e.printStackTrace();
        }
        return keyStore;
    }
    public static void saveKeyStore(KeyStore keyStore) {
        try (FileOutputStream fos = new FileOutputStream("keys.ks")) {
            keyStore.store(fos, "ServerKeyStorePassword".toCharArray());
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
    public static void storeKeyPair(KeyStore keyStore, KeyPair keyPair,
                                      String privateKeyName, String privateKeyPassword) {

        //create the certificate:
        Certificate cert = null;
        try {
            String subjectDN = "CN=Apostolos Kazopidis," +
                    "SURNAME=Kazopidis," +
                    "SERIALNUMBER=213243-1234," +
                    "C=SE," +
                    "DC=kazopidis.com";
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

    public static String encodeBytesBase64(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }
    public static byte[] decodeStringBase64(String base64) {
        return Base64.getDecoder().decode(base64);
    }

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


    public static SecretKey decodeSecretKey(byte[] secretKeyEncrypted, PrivateKey privateKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(secretKeyEncrypted);
        return new SecretKeySpec(decryptedBytes, 0, decryptedBytes.length, "AES"); // stackoverflow
    }

    public static void main(String[] args) {

        // create the keystore and the keypair (if they don't exist), else load them
        KeyStore keyStore;
        PrivateKey privateKey;
        Certificate certificate;
        try {
            keyStore = getLocalKeyStore();
            privateKey = loadPrivateKey(keyStore, "PrivateKeyName", "PrivateKeyPassword");
            certificate = loadCertificate(keyStore, "PrivateKeyName", "PrivateKeyPassword");
        } catch (FileNotFoundException e) {
            keyStore = createKeyStore();
            KeyPair keyPair = createKeyPair();
            privateKey = keyPair.getPrivate();

            storeKeyPair(keyStore, keyPair, "PrivateKeyName", "PrivateKeyPassword");
            saveKeyStore(keyStore);

            certificate = loadCertificate(keyStore, "PrivateKeyName", "PrivateKeyPassword");
        }



        try (ServerSocket server = new ServerSocket(1234)) {

            System.out.println("Server ready!");
            Socket sockClient = server.accept();

            Scanner readFromClient = new Scanner(sockClient.getInputStream(),
                    StandardCharsets.UTF_8);
            PrintWriter writeToClient = new PrintWriter(sockClient.getOutputStream(),
                    true, StandardCharsets.UTF_8);


            // send public key
            PublicKey publicKey = certificate.getPublicKey();
            String publicKeyBase64 = encodeBytesBase64(publicKey.getEncoded());
            writeToClient.println(publicKeyBase64);

            // receive secret key (encoded in Base 64, encrypted with Public Key)
            String secretKeyEncodedEncrypted = readFromClient.nextLine();
            byte[] secretKeyEncrypted = decodeStringBase64(secretKeyEncodedEncrypted);
            // decode Secret Key with Private Key
            SecretKey sessionKey = decodeSecretKey(secretKeyEncrypted, privateKey);


            while(true) {
                String request = readFromClient.nextLine();
                String decryptedRequest = decrypt(request, sessionKey);
                System.out.println("read(encrypted): " + request);
                System.out.println("read(decrypted): " + decryptedRequest);
                if (decryptedRequest.equals("quit")) {
                    System.out.println("Client is done!");
                    break;
                }
                String response = "<server echoing: " + decryptedRequest + ">";
                String encryptedResponse = encrypt(response, sessionKey);
                writeToClient.println(encryptedResponse);
                System.out.println("Sending: " + response + "(encrypted as: " + encryptedResponse + ")");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
