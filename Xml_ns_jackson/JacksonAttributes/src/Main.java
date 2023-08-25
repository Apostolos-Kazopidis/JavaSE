import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        BreakfastMenu menu = new BreakfastMenu(
            new Food[] {
                new Food("Belgian Waffles", "$5.95", "Two of our famous Belgian Waffles with plenty of real maple syrup", "650"),
                new Food("Strawberry Belgian Waffles", "$7.95", "Light Belgian waffles covered with strawberries and whipped cream", "900"),
            },
            "attr-value"
        );


        /* Serialize */
        XmlMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);

        try {
            mapper.writeValue(new File("output.xml"), menu);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* Deserialize */
        try {
            menu = mapper.readValue(new File("output.xml"), BreakfastMenu.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(menu);
    }
}
