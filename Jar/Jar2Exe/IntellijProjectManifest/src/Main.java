import java.util.Scanner;

//Main.java
public class Main {
    public static void main(String[] args) {
        System.out.println(Utils.f() + "Hello World!");

        System.out.println("\nPress Enter to exit...");
        try(Scanner sc = new Scanner(System.in)) {
            sc.next();
        }
    }
}
