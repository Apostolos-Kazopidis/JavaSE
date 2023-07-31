public class Main {

    public static void main(String[] args) {
        //Class<?> personClass = Person.class;

        Class<?> c1 = Teacher.class;
        System.out.println(c1);

        Class<?>[] c = Person.class.getInterfaces();
        for (var inter: c)
            System.out.println(inter);

        for (var method: c1.getMethods())
            System.out.println(method);
    }
}


