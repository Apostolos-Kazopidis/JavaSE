import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        String json = null;
        try {
            json = Files.readString(Path.of("ob.json"));
            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // read
        Widget javaObject = gson.fromJson(json, Widget.class);
        System.out.println(javaObject);

        //write
        json = gson.toJson(javaObject);
        try {
            Files.writeString(Path.of("ob2.json"), json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
