import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        String json = null;
        try {
            json = Files.readString(Path.of("ob.json"));
            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        HashMap<String, Object> map = new HashMap<>();
        map = (HashMap<String, Object>) gson.fromJson(json, map.getClass());
        System.out.println(map);

        json = gson.toJson(map);
        try {
            Files.writeString(Path.of("ob2.json"), json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
