import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        Random r = new Random();

        for (int i=0; i<10; i++)
            al.add(r.nextInt(10));
        System.out.println(al);

        ListIterator<Integer> lit = al.listIterator();
        for (int i=0; i<5; i++)
            System.out.println(lit.next());
        while(lit.hasPrevious())
            System.out.println(lit.previous());

        System.out.println("hasPrevious: " + lit.hasPrevious() + ", index: " + lit.previousIndex());
        System.out.println("hasNext: " + lit.hasNext() + ", index: " + lit.nextIndex());

    }
}
