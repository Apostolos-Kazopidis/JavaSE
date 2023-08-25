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
                System.out.print("--> " + element.getTagName() + ": ");
                // attributes
                NamedNodeMap attributes = element.getAttributes();
                for (int j=0; j<attributes.getLength(); j++) {
                    Node attribute = attributes.item(j);
                    System.out.print(attribute.getNodeName() + "(" +
                            attribute.getNodeValue() + ") ");
                }
                System.out.println();
            }
        }

    }
}
