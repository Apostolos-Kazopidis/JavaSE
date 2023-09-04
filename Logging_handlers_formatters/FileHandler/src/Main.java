import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void loadFile(String fileName, ArrayList<User> users) {
        File f = new File(fileName);

        try(ObjectInputStream os = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(f)))) {
            while(true) {
                users.add((User) os.readObject());
            }
        }
        catch (IOException | ClassNotFoundException e) { }
    }

    public static void main(String[] args) {
        final String fileName = "users.bin";
        ArrayList<User> users = new ArrayList<>();

        loadFile(fileName,users);

        for (int i=0; i<1000; i++) {
            System.out.println(i);
            for (int j=0; j<users.size(); j++) {
                System.out.println(users.get(j));
            }
        }
    }
}
