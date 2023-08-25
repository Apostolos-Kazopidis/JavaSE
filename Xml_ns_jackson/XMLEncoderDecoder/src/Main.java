import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        BreakfastMenu menu = new BreakfastMenu(
            new Food[] {
                new Food("Belgian Waffles", "$5.95", "Two of our famous Belgian Waffles with plenty of real maple syrup", "650"),
                new Food("Strawberry Belgian Waffles", "$7.95", "Light Belgian waffles covered with strawberries and whipped cream", "900"),
                }
        );
        System.out.println(menu);
        // serialize
        try (FileOutputStream fos = new FileOutputStream("example2.xml")) {
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(menu);
            encoder.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (FileInputStream fis = new FileInputStream("example2.xml")) {
            XMLDecoder decoder = new XMLDecoder(fis);
            menu = (BreakfastMenu) decoder.readObject();
            decoder.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(menu);
    }
}
