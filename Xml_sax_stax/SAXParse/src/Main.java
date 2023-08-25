import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }

        try {
            parser.parse("example.xml", new Handler());
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
