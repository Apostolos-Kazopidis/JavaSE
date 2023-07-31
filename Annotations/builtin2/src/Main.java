public class Main {
    public static void main(String[] args) {

        MyClass mc = new MyClass(5);

        mc.printInfo();

        DerivedClass dc = new DerivedClass();

        dc.printInfo();

    }
}