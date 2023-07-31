import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties();

        properties.setProperty("OS", "Windows");
        properties.setProperty("Screen", "Πλαίσιο $%@$#");
        properties.setProperty("Analysis", "640x480");

        try (FileOutputStream fo = new FileOutputStream("system.properties")) {
            properties.storeToXML(fo, "System Properties", StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        properties = new Properties();
        try (FileInputStream fs = new FileInputStream("system.properties")) {
            properties.loadFromXML(fs);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Object o : properties.keySet()) {
            String key = (String) o;
            System.out.println(key + ": " + properties.getProperty(key));
        }

    }
}

