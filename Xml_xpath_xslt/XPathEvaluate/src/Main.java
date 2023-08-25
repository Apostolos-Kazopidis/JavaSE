import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setIgnoringElementContentWhitespace(true);
        factory.setNamespaceAware(true);
        String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
        String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
        factory.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);

        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
            Handler handler = new Handler();
            builder.setErrorHandler(handler);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = null;
        try {
            document = builder != null ? builder.parse("example.xml") : null;
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }


        /* Extract Info with XPath */
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath path = xPathFactory.newXPath();

        try {
            /* Extract a number */
            int calories = ((Number) path.evaluate("breakfast_menu/food[1]/calories",
                    document, XPathConstants.NUMBER)).intValue();
            System.out.println("Calories: " + calories);

            /* Extract a node */
            Node node = (Node) path.evaluate("breakfast_menu/food[1]", document, XPathConstants.NODE);
            System.out.println("Tag: " + node.getNodeName());
            System.out.println("Name: " + node.getFirstChild().getTextContent());

            /* Extract a list of nodes */
            NodeList nodeList = (NodeList) path.evaluate("breakfast_menu/food", document, XPathConstants.NODESET);
            System.out.println("Waffles:");
            for (int i=0; i<nodeList.getLength(); i++) {
                Node food = nodeList.item(i);
                String foodName = food.getFirstChild().getTextContent();
                System.out.println("--> " + foodName);
            }


        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}
