import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
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
            String price = path.evaluate("breakfast_menu/food[1]/price", document);
            System.out.println(price);
            price = path.evaluate("breakfast_menu/food[last()]/price", document);
            System.out.println(price);
            price = path.evaluate("breakfast_menu/food[@attr]/price", document);
            System.out.println(price);
            price = path.evaluate("breakfast_menu/food[@attr='val']/price", document);
            System.out.println(price);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}
