import java.util.LinkedHashMap;
import java.util.Random;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        LinkedHashMap<Integer,String> map = new LinkedHashMap<>();
        LinkedHashMap<Integer,String> map2 = new LinkedHashMap<>(16,0.75f, true);

        Random r = new Random();
        for (int i=0; i<20; i++) {
            int v = r.nextInt(10);
            System.out.println(v);
            map.put(v, "val");
            map2.put(v, "val");
        }
        System.out.println(map);

        for (int i=0; i<2; i++) {
            int v = r.nextInt(10);
            map2.get(v);
            System.out.println(v + "--" + map2);
        }

    }
}
