import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        // make the transformer object
        File xslStylesheet = new File("example.xsl");
        StreamSource xslSource = new StreamSource(xslStylesheet);
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = factory.newTransformer(xslSource);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "html");

        // make wrappers for xml & html => and then transform
        File xmlFile = new File("example.xml");
        File htmlFile = new File("example.html");
        try (InputStream xmlInputStream = new FileInputStream(xmlFile);
             OutputStream htmlOutputStream = new FileOutputStream(htmlFile)) {

            StreamSource xmlSource = new StreamSource(xmlInputStream);
            StreamResult htmlResult = new StreamResult(htmlOutputStream);
            transformer.transform(xmlSource, htmlResult);

        } catch (IOException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
