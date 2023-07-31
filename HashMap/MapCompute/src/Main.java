import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<String,Integer> products = new HashMap<>();

        products.put("boots", 200);
        products.put("footer", 100);
        System.out.println(products);

        System.out.println(products.containsKey("boots") + " " + products.containsKey("belt"));
        products.replace("boots", 220);
        System.out.println(products);

        products.compute("boots", (k,v)->v/2);
        products.computeIfAbsent("belt", (k)->100);
        products.computeIfPresent("footer", (k,v)->v/3);
        System.out.println(products);
    }
}

