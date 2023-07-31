import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        MyIterator ob = new MyIterator();

        while(ob.hasNext()) {
            System.out.println(ob.next());
        }

        MyIterator2 ob2 = new MyIterator2();
        int i=-1;

        while(ob2.hasNext()) {
            System.out.println(ob2.next());
            i++;
            if(i==5) {
                ob2.remove();
                break;
            }
        }

        ob2.forEachRemaining(n-> System.out.println(n*n));
        System.out.println(Arrays.toString(ob2.array));


    }
}