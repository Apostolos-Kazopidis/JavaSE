import javax.xml.stream.*;
import java.io.*;

public class Main {

    public static void writeEntry(XMLStreamWriter writer, String name, String price) {
        try {
            writer.writeStartElement("food");

            writer.writeStartElement("name");
            writer.writeAttribute("active", "1");
            writer.writeCharacters(name);
            writer.writeEndElement();

            writer.writeStartElement("price");
            writer.writeCharacters(price);
            writer.writeEndElement();

            writer.writeEndElement();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        try (OutputStream stream = new FileOutputStream("out.xml")) {
            XMLOutputFactory factory = XMLOutputFactory.newInstance();
            XMLStreamWriter parser = factory.createXMLStreamWriter(stream);


            parser.writeStartDocument();
            parser.writeStartElement("breakfast_menu");
            writeEntry(parser, "Belgian Waffles", "$5.95");
            writeEntry(parser, "Strawberry Belgian Waffles", "$7.95");
            writeEntry(parser, "Berry-Berry Belgian Waffles", "$8.95");
            parser.writeEndElement();
            parser.writeEndDocument();

            parser.close();

        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}

