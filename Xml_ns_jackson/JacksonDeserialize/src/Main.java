import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        BreakfastMenu menu = null;

        XmlMapper mapper = new XmlMapper();

        try {
            menu = mapper.readValue(new File("output.xml"), BreakfastMenu.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(menu);
    }
}
