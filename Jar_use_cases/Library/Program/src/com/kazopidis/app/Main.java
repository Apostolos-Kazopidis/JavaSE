package com.kazopidis.app;

import com.kazopidis.app.models.User;
import com.kazopidis.lib.utils.Utils;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            boolean exit = false;
            while(!exit) {

                System.out.println("==============");
                System.out.println("Menu");
                System.out.println("1-Insert User");
                System.out.println("2-Delete User");
                System.out.println("3-Print Users");
                System.out.println("4-exit");
                int choice = Utils.readInt(sc, 1, 4);


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
                        int role = Utils.readInt(sc,1,2);
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
                }
            }

        }
    }
}