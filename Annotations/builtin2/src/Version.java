import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(Versions.class)
public @interface Version {
    String number();
    String descr();
}
