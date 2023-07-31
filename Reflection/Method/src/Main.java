import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<?> personClass = Person.class;

        Method[] methods = personClass.getMethods();
        for (var method: methods)
            System.out.println(method);

        System.out.println("=".repeat(30));
        Method method = personClass.getDeclaredMethod("printSalary");
        System.out.println(method);

        Person p = new Person("John", "Doe", "15th str.", 1000);
        method.setAccessible(true);
        method.invoke(p);
    }
}


