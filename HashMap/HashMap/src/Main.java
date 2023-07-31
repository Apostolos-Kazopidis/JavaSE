import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<String,String> hero = new HashMap<>();

        hero.put("name", "Natasha Romanoff");
        hero.put("alias", "Black Widow");
        hero.put("ability", "Hand to hand combat");

        System.out.println(hero.get("name") + "(" + hero.get("alias") + ") uses " + hero.get("ability"));
    }
}
