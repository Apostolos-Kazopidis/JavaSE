import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        /* for validation */
        SchemaFactory schemaFactory = SchemaFactory.newDefaultInstance();
        factory.setSchema(schemaFactory.newSchema(new File("example.xsd")));

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
