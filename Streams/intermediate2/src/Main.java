import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> al = new ArrayList<>();
        Collections.addAll(al,"5.2","1.6","1.1","4.44","1.52");

        al.stream()
                .mapToDouble(Double::valueOf)
                .peek(x-> System.out.print(x+" "))
                .sorted()
                .takeWhile(x->x<=4)
                .forEach(x-> System.out.print("\n" + x));


    }
}