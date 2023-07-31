import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        Collections.addAll(set,1,8);

        Set<Integer> unmodSet = Collections.unmodifiableSet(set);
        System.out.println(unmodSet);
        set.add(3);
        System.out.println(unmodSet);
        unmodSet.add(5); // throws: UnsupportedOperationException

    }
}

