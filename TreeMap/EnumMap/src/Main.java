import java.util.EnumMap;

public class Main {

    public static void main(String[] args) {
        EnumMap<Day,Integer> map = new EnumMap<>(Day.class);
        map.put(Day.WEDNESDAY, 6);
        map.put(Day.MONDAY, 2);
        System.out.println(map);
    }
}
