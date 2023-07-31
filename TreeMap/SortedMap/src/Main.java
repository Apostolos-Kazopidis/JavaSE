import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        TreeMap<Integer,String> map = new TreeMap<>();

        for (int i=0; i<10; i++)
            map.put(i, "string" + i);

        System.out.println(map);
        System.out.println(map.firstKey());
        System.out.println(map.lastKey());
        System.out.println(map.headMap(5));
        System.out.println(map.subMap(4,8));
        System.out.println(map.tailMap(5));
    }
}
