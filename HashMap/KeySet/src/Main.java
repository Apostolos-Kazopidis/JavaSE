import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashMap<String,String> dict = new HashMap<>();

        dict.put("NYC", "Empire State Building");
        dict.put("Dubai", "Burj Khalifa");
        dict.put("Shanghai", "Shanghai Tower");

        TreeSet<String> sortedKeys = new TreeSet<>(dict.keySet());

        for (var key: sortedKeys)
            System.out.println(key +": " + dict.get(key));
    }
}
