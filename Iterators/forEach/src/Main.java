import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> al = new ArrayList<>();

        for (int i=0; i<50; i++)
            al.add(i);

        System.out.println(al);

        //al.forEach(System.out::println);
        al.forEach((n)->System.out.println(n));

    }
}
