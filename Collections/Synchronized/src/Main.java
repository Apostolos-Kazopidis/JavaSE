import java.util.*;

public class Main {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        t.setName("The Parent");

        List<Integer> sl = Collections.synchronizedList(
                new LinkedList<>()
        );

        Thread[] producers = new Thread[2];
        for (int i=0; i<producers.length; i++) {
            producers[i] = new Thread(new Producer(i * 10, sl));
            producers[i].start();
        }

        Thread[] consumers = new Thread[3];
        for (int i=0; i<consumers.length; i++) {
            consumers[i] = new Thread(new Consumer(i, sl));
            consumers[i].start();
        }

        try {
            for (int i=0; i<producers.length; i++)
                producers[i].join(); //join panw stous producers gia na perimenei to kentriko nhma
            for (int i=0; i<consumers.length; i++)
                consumers[i].interrupt();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(t + ": exiting");
    }
}
