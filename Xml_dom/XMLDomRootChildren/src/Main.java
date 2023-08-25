import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
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

        /* The root and its children */
        Element root = document.getDocumentElement();
        System.out.println("root: " + root);
        NodeList children  = root.getChildNodes();
        for (int i=0; i<children.getLength(); i++) {
            Node node = children.item(i);
            System.out.println(node);
        }

    }
}
