import java.util.Iterator;

public class Animals implements Iterable<String> {
    int n;
    String[] animals;

    public Animals() {
        n = 5;
        animals = new String[n];
        animals[0] = "cat";
        animals[1] = "dog";
        animals[2] = "horse";
        animals[3] = "pig";
        animals[4] = "cow";
    }

    class ClassIterator implements Iterator<String> {
        int i=-1;
        @Override
        public boolean hasNext() {
            return i<n-1;
        }

        @Override
        public String next() {
            i++;
            return animals[i];
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new ClassIterator();
    }

}
