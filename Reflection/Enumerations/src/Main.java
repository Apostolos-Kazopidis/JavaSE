public class Main {

    public static void main(String[] args) {
        /*
        Class<?> enumClass = Days.class;
        System.out.println(enumClass);

        Object[] constants = enumClass.getEnumConstants();
        for (var constant: constants)
            System.out.println(constant);

         */

        Class<?> enumClass = Days.class;
        System.out.println(enumClass);

        Object[] constants = enumClass.getEnumConstants();
        for(var constant: constants)
            System.out.println(constant);


    }
}


