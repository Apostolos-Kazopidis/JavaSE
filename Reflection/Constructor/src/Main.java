import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<?> personClass = Person.class;

        Constructor<?> constructor = personClass.getConstructor(
                String.class, String.class,
                String.class, double.class);

        System.out.println(constructor);

        Person p = (Person) constructor.newInstance(
                "John", "Doe", "15th str.", 1000);

        System.out.println(p);
    }
}


