import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) {

        Class<?> personClass = Person.class;

        Field[] fields = personClass.getDeclaredFields();
        for (var field: fields)
            System.out.println(field);

        Person p = new Person("John", "Doe", "15th str.", 1000);

        try {
            System.out.println(p);
            Field field = personClass.getDeclaredField("firstName");
            field.setAccessible(true);
            field.set(p, "Bob");
            System.out.println(p);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}


