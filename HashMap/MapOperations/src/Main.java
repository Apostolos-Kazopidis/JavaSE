import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashMap<String,String> dict = new HashMap<>();

        dict.put("ιταμός", "προκλητικός, αυθάδης, αναιδής");
        dict.put("όνειδος", "ντροπή, καταισχύνη");
        dict.put("πομφόλυγες", "αερολογίες, ανοησίες");

        System.out.println(dict.get("ιταμός"));
        System.out.println(dict.get("φληναφήματα"));
        System.out.println(dict);

        System.out.println(dict.remove("ιταμός"));
        System.out.println(dict.remove("φληναφήματα","δεν υπάρχει το λήμμα"));
        System.out.println(dict);

        System.out.println(dict.size());
        dict.clear();
        System.out.println(dict.size());

    }
}