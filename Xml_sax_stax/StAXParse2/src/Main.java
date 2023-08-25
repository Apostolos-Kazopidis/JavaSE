import javax.xml.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (InputStream stream = new FileInputStream("example.xml")) {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader parser = factory.createXMLStreamReader(stream);

            while(parser.hasNext()) {
                int event = parser.next();

                if (event== XMLStreamConstants.START_ELEMENT) {
                    System.out.println("Start Element: " + parser.getLocalName());
                    for (int i=0; i<parser.getAttributeCount(); i++)
                        System.out.println(" " + parser.getAttributeName(i) + "=" +
                                parser.getAttributeValue(i));
                }
                else if (event == XMLStreamConstants.END_ELEMENT) {
                    System.out.println("End Element");
                }
                else if (event == XMLStreamConstants.CHARACTERS) {
                    if (!parser.getText().trim().equals(""))
                        System.out.println("\tText: " + parser.getText().trim());
                }
            }
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
