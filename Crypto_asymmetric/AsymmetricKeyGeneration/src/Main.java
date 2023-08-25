import java.security.*;
import java.util.Base64;

public class Main
{
    public static void main(String[] args)
    {
        KeyPairGenerator keyPairGenerator = null;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        System.out.println("Public: " + publicKey + ", private: " + privateKey);

        System.out.println("Public Key(Base64): " +
                        Base64.getEncoder().encodeToString(publicKey.getEncoded())
                );
        System.out.println("Private Key(Base64): " +
                        Base64.getEncoder().encodeToString(privateKey.getEncoded())
                );
    }
}