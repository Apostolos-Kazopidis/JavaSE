import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * {@summary Program's main class}
 *
 * <ul>
 *     <li>The {@link Main main()} coordinator</li>
 *     <li>File Manipulation functions ({@link Main#saveFile(String, ArrayList) saveFile()}, {@link Main#loadFile(String, ArrayList) loadFile()})</li>
 *     <li>An auxiliary function: {@link #readInt(Scanner, int, int) readInt()} {@index auxiliary (auxiliary functions)}</li>
 * </ul>
 * There are no command line arguments: Just call {@code main()}
 *
 * @author Jim Psoun
 * @see <a href="https://www.youtube.com/playlist?list=PLLMmbOLFy25GFF3fWoiJ56nM8Kqgr_Qe2">Playlist</a>
 * @see User
 * @version 0.1
 */
public class Main {

    /**
     * {@summary Reads user's choice on the menu}
     * This function reads user's choice after the menu is displayed.
     * The input should be an integer: lower&lt;=integer&lt;=upper.
     * @param sc The scanner object
     * @param lower lower bound (integer)
     * @param upper upper bound (integer)
     * @return user's choice
     * @throws InputMismatchException When input's type is not an integer
     */
    public static int readInt(Scanner sc, int lower, int upper) {
        int choice;
        while(true) {
            System.out.print("Your choice: ");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                if (choice < lower || choice > upper) {
                    System.out.println("Error: Between " + lower + " and " + upper);
                }
                else
                    return choice;
            }
            else
                throw new InputMismatchException("Wrong input");
        }
    }

    public static void saveFile(String fileName, ArrayList<User> users) {
        File f = new File(fileName);

        try(ObjectOutputStream os = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(f)))) {
            for (int i=0; i<users.size(); i++)
                os.writeObject(users.get(i));
        }
        catch (IOException e) {
            System.err.println(e);
        }
    }

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


        try (Scanner sc = new Scanner(System.in)) {
            boolean exit = false;
            while(!exit) {

                System.out.println("==============");
                System.out.println("Menu");
                System.out.println("1-Insert User");
                System.out.println("2-Delete User");
                System.out.println("3-Print Users");
                System.out.println("4-exit");
                int choice = readInt(sc, 1, 4);

                switch(choice) {
                    case 1:
                        sc.nextLine();
                        System.out.println("Insert new user");
                        System.out.print("Full name: ");
                        String fullName = sc.nextLine();
                        System.out.print("username: ");
                        String username = sc.next();
                        System.out.print("password: ");
                        String password = sc.next();
                        System.out.print("Role(1-admin, 2-user): ");
                        int role = readInt(sc,1,2);
                        users.add(new User(fullName, username, password, role));
                        System.out.println("User added! ");

                        break;
                    case 2:
                        sc.nextLine();
                        System.out.println("Delete user");
                        System.out.print("Give full name: ");
                        String name = sc.nextLine();


                        boolean found = false;
                        for (int i=0; i<users.size(); i++) {
                            if (users.get(i).getFullName().equals(name)) {
                                found = true;
                                users.remove(i);
                                System.out.println("User deleted! ");
                                break;
                            }
                        }
                        if (!found)
                            System.out.println("User doesn't exist!");

                        break;
                    case 3:
                        for (int i=0; i<users.size(); i++)
                            System.out.println(users.get(i));
                        break;
                    case 4:
                        exit=true;
                        saveFile(fileName,users);
                }
            }

        }
    }
}
