import java.util.WeakHashMap;

public class Main {

    public static void main(String[] args) {
        WeakHashMap<String,Object> map = new WeakHashMap<>();
        String attr1 = new String("name");
        String attr2 = new String("age");
        map.put(attr1, "John");
        map.put(attr2, 34);

        System.out.println(map);
        attr2 = null;
        System.gc();
        System.out.println(map);
    }
}
