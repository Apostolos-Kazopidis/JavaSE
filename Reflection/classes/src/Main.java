public class Main {

    public static void main(String[] args) {

        try {
            Class<?> myClass = Class.forName("Person");
            System.out.println(myClass.getName());
            for (var method: myClass.getMethods())
                System.out.println(method);
            System.out.println("=".repeat(20));
            for (var field: myClass.getFields())
                System.out.println(field);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


