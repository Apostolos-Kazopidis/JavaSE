@MyAnno(name="Bob", team="Bob Team")
public class MyClass implements MyInterface{
    @MyAnno(name="Pam")
    public int x;

    @Override
    @MyAnno(name="Bob", team="Bob Team")
    public void f() { }

    public void g(@MyAnno(name="Tom") int x) { }
}
