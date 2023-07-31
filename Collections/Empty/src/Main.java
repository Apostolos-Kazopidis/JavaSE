import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        Collections.addAll(set,1,8);

        if (set.equals(Collections.emptySet()))
            System.out.println("Set is empty");
        else
            System.out.println("Do something with the set");
    }
}

