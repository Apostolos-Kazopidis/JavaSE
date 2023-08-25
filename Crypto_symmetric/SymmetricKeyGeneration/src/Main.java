import java.security.*;
import javax.crypto.*;

public class Main
{
    public static void main(String[] args)
    {
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        SecretKey key = keyGenerator.generateKey();
        System.out.println(key);
    }
}