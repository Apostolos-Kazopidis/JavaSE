import java.util.Iterator;
import java.util.function.Consumer;

public class MyIterator2 implements Iterator<Integer> {
    int n = 10;
    int i = -1;
    int[] array;

    public MyIterator2() {
        array = new int[n];
        for(int i=0; i<n; i++) {
            array[i] = i;
        }
    }

    @Override
    public boolean hasNext() {
        return i<n-1;
    }

    @Override
    public Integer next() {
        i++;
        return array[i];
    }

    @Override
    public void remove() {
        if(i<n) {
            int[] newArray = new int[n-1];
            for(int j=0; j<i; j++)
                newArray[j] = array[j];
            for(int j=i+1; j<n; j++)
                newArray[j-1]=array[j];
            n--;
            array=newArray;
        }
    }

    @Override
    public void forEachRemaining(Consumer<? super Integer> action) {
        for(int j=i+1; j<n; j++)
            action.accept(array[j]);
    }
}
