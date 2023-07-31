import java.util.ArrayList;
import java.util.Spliterator;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();

        for (int i=0; i<50; i++)
            al.add(i);
        System.out.println(al);

        Spliterator<Integer> split = al.spliterator();
        Spliterator<Integer> split2 = split.trySplit();

        System.out.println("Spliterator 1:");
        while (split.tryAdvance(
                (n)->System.out.println(n)
        ));

        if (split2!=null) {
            System.out.println("Spliterator 2:");
            while (split2.tryAdvance(
                    (n)->System.out.println(n)
            ));
        }

    }
}
