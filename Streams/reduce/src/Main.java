import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> al = new ArrayList<>();
        Collections.addAll(al, 1,2,3,4,5);

        Optional<Integer> res = al.stream()
                .reduce((acc, x)->acc+x);
        System.out.println(res.orElse(null));

        Optional<Integer> res2 = al.stream()
                .reduce((acc, x)-> {
                    if (x>3)
                        return acc + x;
                    else return acc;
                });
        System.out.println(res2.orElse(null));

    }
}


