import java.util.ArrayList;
import java.util.List;


@SuppressWarnings({"rawtypes", "unchecked"})
public class Main {
    public static void main(String[] args) {
        TestFuncInter t = new TestFuncInter();
        t.f();

        // warning raw types
        List l = new ArrayList<String>();
        // warning unchecked
        l.add("test");
        System.out.println(l);


        @SuppressWarnings("deprecation") MyDeprClass ob = new MyDeprClass();
        ob.print();
        MyDeprClass ob2 = new MyDeprClass();
    }
}

