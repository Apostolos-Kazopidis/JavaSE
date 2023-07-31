import java.util.Comparator;

public class NameComparator implements Comparator<Person2> {
    @Override
    public int compare(Person2 o1, Person2 o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
