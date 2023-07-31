import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties();

        properties.setProperty("OS", "Windows");
        properties.setProperty("Screen", "Πλαίσιο $%@$#");
        properties.setProperty("Analysis", "640x480");

        try (FileWriter fw = new FileWriter("system.properties", StandardCharsets.UTF_8)) {
            properties.store(fw, "System Properties");
        } catch (IOException e) {
            e.printStackTrace();
        }

        properties = new Properties();
        try (FileReader fr = new FileReader("system.properties", StandardCharsets.UTF_8)) {
            properties.load(fr);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Object o : properties.keySet()) {
            String key = (String) o;
            System.out.println(key + ": " + properties.getProperty(key));
        }

    }
}

