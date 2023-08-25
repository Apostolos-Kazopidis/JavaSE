import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = null;
        try {
            document = builder != null ? builder.parse("example.xml") : null;
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        Element root = document.getDocumentElement();
        System.out.println("root: " + root.getTagName());
        NodeList children  = root.getChildNodes();
        for (int i=0; i<children.getLength(); i++) {
            Node node = children.item(i);
            if (node instanceof Element) {
                Element element = (Element) node;
                System.out.println("Element");
                System.out.println("--> " + element.getTagName());
                System.out.println("--> " + element.getTextContent());
            }
            else if (node instanceof Text) {
                Text text = (Text) node;
                System.out.println("Text");
                System.out.println("--> " + text.getTextContent());
            }
        }

    }
}
