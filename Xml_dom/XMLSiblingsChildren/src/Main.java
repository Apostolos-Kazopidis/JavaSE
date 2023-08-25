import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
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

        Node secondFood = root.getFirstChild()
                .getNextSibling()
                .getNextSibling().getNextSibling();
        System.out.println(secondFood.getTextContent());

        Node caloriesLastFood = root.getLastChild()
                .getPreviousSibling()
                .getLastChild().getPreviousSibling();
        System.out.println(caloriesLastFood.getTextContent());

    }
}
