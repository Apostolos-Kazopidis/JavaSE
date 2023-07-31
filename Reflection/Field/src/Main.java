import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) {

        Class<?> personClass = Person.class;

        Field[] fields = personClass.getFields();
        for (var field: fields)
            System.out.println(field);

        Person p = new Person("John", "Doe", "15th str.", 1000);

        try {
            personClass.getField("x").setInt(p, 3);
            System.out.println(p.x);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}


