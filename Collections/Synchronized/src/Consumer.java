import java.util.List;

public class Consumer implements Runnable {
    private List<Integer> resource;
    int id;

    public Consumer(int id, List<Integer>  resource) {
        this.id = id;
        this.resource = resource;
    }

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        t.setName("Consumer" + id);

        while (true) {
            // adding to the resource
            try {
                int item = resource.remove(0);
                System.out.println(t + " removed " + item);
            } catch (IndexOutOfBoundsException ob) { }
            if (t.isInterrupted())
                break;
        }
        System.out.println(t + " finished! ");
    }
}
