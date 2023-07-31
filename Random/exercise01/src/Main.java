import java.util.Random;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> stats = new TreeMap<>();

        for (int k=-10; k<=9; k++)
            stats.put(k, 0);

        Random r = new Random();
        int cnt = 0;
        for (int i=0; i<1000000; i++) {
            double randVal = r.nextGaussian();
            if (Math.abs(randVal)<=1) {
                int key = (int) Math.floor(randVal * 10);
                stats.put(key, stats.get(key) + 1);
                cnt++;
            }
        }

        for (var key: stats.keySet())
            System.out.println("[" + key/10.0 + ", " + (key+1)/10.0 + "): " +
                    stats.get(key) + " (" + stats.get(key)/(double)cnt + ")");
    }
}

