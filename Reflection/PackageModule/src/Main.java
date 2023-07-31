import myPackage.Person;

public class Main {

    public static void main(String[] args) {
        Class<?> personClass = Person.class;

        Package pack = personClass.getPackage();
        System.out.println(pack);

        Module mod = personClass.getModule();
        System.out.println(mod);
        for (var p: mod.getPackages())
            System.out.println(p);
    }
}


