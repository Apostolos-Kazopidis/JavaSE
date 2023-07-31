import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
    String name();
    String team() default "Programming Team 1";
    int version() default 1;
}
