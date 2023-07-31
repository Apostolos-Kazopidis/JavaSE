import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> al = new ArrayList<>();
        Collections.addAll(al, "aba","bac","aac","ada","bba");

        List<String> array = al.stream()
                .sorted()
                .map(x->x+x)
                .filter(x->x.matches(".*aa.*"))
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(array);

    }
}


