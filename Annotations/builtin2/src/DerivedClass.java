import java.lang.annotation.Annotation;

@Version(number = "1.1", descr = "added constructor")
@Version(number="1.2", descr="added printInfo")
public class DerivedClass extends MyClass {

    public DerivedClass() {
        super(3);
    }

    public void printInfo() {
        System.out.println("Derived MyAnno Annotation: " + getClass().getAnnotation(MyAnno.class));
        System.out.println("Derived MyAnno Annotation: name: " + getClass().getAnnotation(MyAnno.class).name());
        System.out.println("Derived MyAnno Annotation: team: " + getClass().getAnnotation(MyAnno.class).team());
        System.out.println("Derived MyAnno Annotation: version: " + getClass().getAnnotation(MyAnno.class).version());

        System.out.println("=".repeat(50));
        Annotation[]ob = getClass().getAnnotations();
        for(var anno: ob) {
            System.out.println(anno);
        }
    }


}
