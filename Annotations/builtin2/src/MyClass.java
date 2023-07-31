
@MyAnno(name="George")
public class MyClass {
    private int x;

    public MyClass(int x) {
        this.x = x;
    }

    public void printInfo() {
        System.out.println("MyClass MyAnno Annotation: "+getClass().getAnnotation(MyAnno.class));
        System.out.println("MyClass MyAnno Annotation: name:"+getClass().getAnnotation(MyAnno.class).name());
        System.out.println("MyClass MyAnno Annotation: version:"+getClass().getAnnotation(MyAnno.class).version());
        System.out.println("MyClass MyAnno Annotation: team:"+getClass().getAnnotation(MyAnno.class).team());
    }

}
