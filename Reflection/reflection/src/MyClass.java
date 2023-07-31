@MyAnno(name="Jim")
public class MyClass {
    private int x;

    public MyClass(int x) {
        this.x = x;
    }

    @MyAnno(name="Bob")
    public void print() {
        System.out.println(x);
    }

    public void printInfo() {
        System.out.println("Class: " + getClass());
        System.out.println("Annotation: " + MyAnno.class);
        System.out.println("MyClass MyAnno Annotation: " +
                getClass().getAnnotation(MyAnno.class));
        System.out.println("MyClass MyAnno Annotation: name: " +
                getClass().getAnnotation(MyAnno.class).name());
        System.out.println("MyClass MyAnno Annotation: team: " +
                getClass().getAnnotation(MyAnno.class).team());
        System.out.println("MyClass MyAnno Annotation: version: " +
                getClass().getAnnotation(MyAnno.class).version());

        try {
            System.out.println("MyClass print method: " +
                    getClass().getMethod("print"));
            System.out.println("MyClass print method myAnno annotation: " +
                    getClass().getMethod("print").getAnnotation(MyAnno.class));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
