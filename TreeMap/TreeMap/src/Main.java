import java.util.Comparator;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        TreeMap<String,String> hero = new TreeMap<>();

        hero.put("name", "Natasha Romanoff");
        hero.put("alias", "Black Widow");
        hero.put("ability", "Hand to hand combat");

        System.out.println(hero);

        //Constructor with the comparator
        TreeMap<String, String> hero2 = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        hero2.put("name", "Natasha Romanoff");
        hero2.put("alias", "Black Widow");
        hero2.put("ability", "Hand to hand combat");
        System.out.println(hero2);

    }
}
