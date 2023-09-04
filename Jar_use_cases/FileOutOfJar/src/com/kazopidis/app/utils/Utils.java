package com.kazopidis.app.utils;
import com.kazopidis.app.models.User;

import java.io.*;
import java.util.*;

public class Utils {
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
            else {
                sc.next();
                System.out.println("Error: Invalid input");
            }
        }
    }

    public static void saveFile(String fileName, ArrayList<User> users) {
        File f = Resources.getFile(fileName);

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
        File f = Resources.getFile(fileName);
        int recordCount = 0;
        try(ObjectInputStream os = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(f)))) {
            while(true) {
                users.add((User) os.readObject());
                recordCount ++;
            }
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println(recordCount + " records in file. ");
        }
    }
}
