import java.util.List;

public class Producer implements Runnable {
    private int init;
    private List<Integer> resource;

    public Producer(int init, List<Integer>  resource) {
        this.init = init;
        this.resource = resource;
    }

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        t.setName("Producer" + init);

        for (int i = init; i < init + 4; i++) {
            // processing some data
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            // adding to the resource
            resource.add(i);
            System.out.println(t + " added " + i);
        }
        System.out.println(t + " finished! ");
    }
}
